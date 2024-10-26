git clone https://github.com/big-data-europe/docker-hive.git
cd docker-hive
docker-compose up -d

CONNECT BY DBeaver: jdbc:hive2://localhost:10000

-- скачиваем датасет "Books Dataset" -Онлайн-данные о книгах с Amazon, а также рейтинги пользователей и данные о тех, кто их купил
https://www.kaggle.com/datasets/saurabhbagchi/books-dataset?resource=download

/*файл содержит три файла:
1. books.csv  	- таблица книг
2. ratings.csv 	- таблица рейтингов книг
3. users.csv 	- таблица пользователей
*/

-- выполним преобразования для Dbeaver
sed -i "s/\"/@/g" books.csv
sed -i "s/\"/@/g" ratings.csv
sed -i "s/\"/@/g" users.csv
"
-- упаковываем датасеты в docker - контейнер
docker ps
-- ~\ путь до папки с файлом (индивидуально)
docker cp ~\ \books.csv docker-hive-hive-server-1:/opt
docker cp ~\ \ratings.csv docker-hive-hive-server-1:/opt
docker cp ~\ \\users.csv docker-hive-hive-server-1:/opt

docker-compose exec hive-server bash

-- Create folders on HDFS:
hdfs dfs -mkdir /user/hive/warehouse/books
hdfs dfs -mkdir /user/hive/warehouse/ratings
hdfs dfs -mkdir /user/hive/warehouse/book_users

-- Upload data to HDFS:
hdfs dfs -put books.csv /user/hive/warehouse/books
hdfs dfs -put ratings.csv /user/hive/warehouse/ratings
hdfs dfs -put users.csv /user/hive/warehouse/book_users

-- Check that data exist:
hdfs dfs -ls /user/hive/warehouse/books
hdfs dfs -ls /user/hive/warehouse/ratings
hdfs dfs -ls /user/hive/warehouse/book_users

-- Run with hive console:
hive

-- check that databases exist:
show databases;

-- create a new database <books_data>
DROP DATABASE IF EXISTS books_data CASCADE;
CREATE DATABASE books_data;

-- create external tables
-- create external table <books_ext>
DROP TABLE IF EXISTS books_data.books_ext;
CREATE EXTERNAL TABLE books_data.books_ext(
	  isbn STRING
	, book_title STRING
	, book_author STRING
	, year_of_publication STRING
	, publisher STRING
	, image_url_s STRING
	, image_url_l STRING
)
COMMENT 'This is an external table of <books>'
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde' -- сериализация
WITH SERDEPROPERTIES(
    "quoteChar"="@",
    "separatorChar"=";"
)
STORED AS TEXTFILE
LOCATION '/user/hive/warehouse/books'
tblproperties("skip.header.line.count"="1");  -- пропускаем заголовок CSV-file

-- check of data exist
SELECT COUNT(*) FROM books_data.books_ext;

--------------------------

-- create external table <ratings_ext>
DROP TABLE IF EXISTS books_data.ratings_ext;
CREATE EXTERNAL TABLE books_data.ratings_ext(
      id_user STRING
    , isbn STRING
    , book_rating STRING
)
COMMENT 'This is an external table of <ratings>'
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde' -- сериализация
WITH SERDEPROPERTIES(
    "quoteChar"="@",
    "separatorChar"=";"
)
STORED AS TEXTFILE
LOCATION '/user/hive/warehouse/ratings'
tblproperties("skip.header.line.count"="1"); -- пропускаем заголовок CSV-file

-- check of data exist
SELECT COUNT(*) FROM books_data.ratings_ext;

--------------------------

-- create external table <users_ext>
DROP TABLE IF EXISTS books_data.users_ext;
CREATE EXTERNAL TABLE IF NOT EXISTS books_data.users_ext(
      id_user STRING
    , location STRING
    , age STRING
)
COMMENT 'This is an external table of <users>'
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde' -- сериализация
WITH SERDEPROPERTIES(
    "quoteChar"="@",
    "separatorChar"=";"
)
STORED AS TEXTFILE
LOCATION '/user/hive/warehouse/book_users'
tblproperties("skip.header.line.count"="1"); -- пропускаем заголовок CSV-file

-- check of data exist
SELECT COUNT(*) FROM books_data.users_ext;

--------------------------------
--------------------------------
-- create a partitioned table books
-- настроим партицирование
SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nostrict;

-- создадим таблицу <books>
DROP TABLE IF EXISTS books_data.books;
CREATE TABLE IF NOT EXISTS books_data.books(
	isbn INT,
	book_title STRING,
	book_author STRING,
	year_of_publication INT,
	publisher STRING,
	image_url_s STRING,
	image_url_l STRING
)
STORED AS ORC;

-- заполним таблицу <books>
INSERT OVERWRITE TABLE books_data.books
SELECT CAST(isbn AS INT)
     , book_title
     , book_author
     , CAST(year_of_publication AS INT)
     , publisher
     , image_url_s
     , image_url_l
FROM books_data.books_ext;

select count(*) from books_data.books;  -- 271 379 rows

----------------------------
-- создадим партицированную по полю "book_rating" таблицу <ratings_part>
DROP TABLE IF EXISTS books_data.ratings_part;
CREATE TABLE IF NOT EXISTS books_data.ratings_part(
	  id_user INT
	, isbn INT
)
PARTITIONED BY (book_rating INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|';

-- заполним таблицу <ratings_part>
INSERT INTO TABLE books_data.ratings_part PARTITION(book_rating)
SELECT CAST(id_user AS INT) AS id_user
	 , CAST(isbn AS INT) AS isbn
	 , CAST(book_rating AS INT) AS book_rating
FROM books_data.ratings_ext;  -- 11 partitions


-----------------------------

-- создадим таблицу <users>
DROP TABLE IF EXISTS books_data.users;
CREATE TABLE IF NOT EXISTS books_data.users(
	  id_user INT
	, country STRING
	, region STRING
	, city STRING
	, age INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '|';

-- заполним таблицу <users>
INSERT INTO TABLE books_data.users
SELECT CAST(id_user AS INT) AS id_user
	 , split(location, ',')[2] AS country
	 , split(location, ',')[1] AS region
	 , split(location, ',')[0] AS city
	 , CAST(age AS INT) AS age
FROM books_data.users_ext;

-----------------------------

-- создаем витрины

-- 1. витрина топ-20 стран по кол-ву пользователей
SELECT country
	 , COUNT(*) AS cnt
FROM books_data.users
WHERE country IS NOT NULL AND country <> ''
GROUP BY country
ORDER BY cnt DESC
LIMIT 20;


-- 2. витрина пользователей, которые оценили свыше 1000 книг
SELECT u.id_user, COUNT(rp.isbn) AS cnt_isbn
FROM books_data.users u
INNER JOIN books_data.ratings_part rp
ON u.id_user = rp.id_user
GROUP BY u.id_user
HAVING cnt_isbn > 1000
ORDER BY cnt_isbn DESC;


-- 3. витрина ранжирования кол-ва пользователей по странам
SELECT DISTINCT trim(u.country)
	 , COUNT(*) OVER(PARTITION BY trim(country)) AS cnt_users
FROM books_data.users u
WHERE u.country IS NOT NULL AND u.country <> ''
ORDER BY cnt_users DESC;


-- 4. топ-5 оцениваемых авторов + кол-во их книг с рейтингом = 10
SELECT b.book_author
	 , COUNT(*) AS rating_10
FROM books_data.books b
INNER JOIN books_data.ratings_part r
ON b.isbn = r.isbn
WHERE r.book_rating = 10 and b.book_author IS NOT NULL
GROUP BY b.book_author
ORDER BY rating_10 DESC
LIMIT 5;


-- 5. витрина топ-5 самых популярных издательств
SELECT publisher
	 , COUNT(isbn) AS cnt_isbn
FROM books_data.books b
WHERE isbn IS NOT NULL
GROUP BY publisher
ORDER BY cnt_isbn DESC
LIMIT 5;

---------------------

docker-compose down
docker system prune -a

















