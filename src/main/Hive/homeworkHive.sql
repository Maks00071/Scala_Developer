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
























