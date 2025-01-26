package scala3.scala3_1

import scala.collection.immutable
import scala.collection.mutable


object MyCollections3 {
  def main(args: Array[String]): Unit = {

    // collection list
    val demoCollections1: immutable.Seq[String] = "line1" :: "line2" :: "line3" :: Nil
    val demoCollections2 = List("line1", "line2", "line3")

    println(demoCollections1)
    println(demoCollections2)

    // collection Set
    val demoSet = ("list1" :: "list2" :: "list3" :: Nil).toSet
    demoSet.foreach(x => println(x))

    println("--------------------------------------------")

    // collection Map
    ("line1" :: "line2" :: "line3" :: Nil).groupBy(x=>x).map(x=>x._1).foreach(x=>println(x))

    println("--------------------------------------------")

    case class TestCaseClass(x: String, y: Int)
    val test1 = new TestCaseClass("1", 1)
    val test2 = new TestCaseClass("2", 2)
    val test3 = new TestCaseClass("3", 2)
    val test4 = new TestCaseClass("4", 2)

    (test1 :: test2 :: test3 :: test4 :: Nil)
      .groupBy(x => x.y)
      .map(x => x._2.head)
      .foreach(u => println(u))

    println("--------------------------------------------")

    // выполним задачу: создадим список списков и выведем те списки, где сумма элементов больше 10
    val testSum = List(1,2,3,4,5) :: List(1,50,3) :: List(1,2) :: Nil
    testSum.filter(x => x.sum > 10).foreach(x => println(x.mkString(",")))

    //функции свертки
    println("demo collection folds")
    val demoCollections3 = 1 :: 2 :: 3 :: 4 :: Nil
    println(s"fold result: ${demoCollections3.fold(0)((z,i) => z + i)}") // fold result: 10

    // свертка слева-направо
    println(s"foldLeft result: ${demoCollections3.foldLeft(0)((z,i) => z + i)}") // foldLeft result: 10

    //реализуем flatMap

    /**
     * Function преобразует String to Integer
     * @param strInput String
     * @return Integer
     */
    def parseInt(strInput: String): Option[Int] = {
      try {
        Some(strInput.toInt)
      } catch {
        case _: NumberFormatException => None
      }
    }

    /**
     * Function делит четное число пополам
     * @param number Integer
     * @return number / 2
     */
    def divideByTwo(number: Int): Option[Int] = {
      if (number % 2 == 0) Some(number / 2)
      else None
    }

    val input: String = "8"
    println(parseInt(input).flatMap(divideByTwo)) // Some(4)
    println(parseInt("6f").flatMap(divideByTwo)) // None

  }
}



























