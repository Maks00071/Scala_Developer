package scala3.scala3_1

import scala.collection.immutable

object MyCollections {
  def main(args: Array[String]): Unit = {

    // collection List
    val demoCollection1: immutable.Seq[String] = "line1" :: "line2" :: "line3" :: Nil
    val demoCollection2 = List("line1", "line2", "line3")

    // collection Set
    val demoSet = ("line1" :: "line2" :: "line3" :: "line3" :: Nil).toSet
    demoSet.foreach(x => println(x))

    println("-----------------------------")

    // collection map
    ("line1" :: "line2" :: "line3" :: "line3" :: Nil).groupBy(x => x).map(x => x._1).foreach(x => println(x))

    println("-----------------------------")

    case class testCaseClass(x: String, y: Int)
    val test1 = new testCaseClass("1", 1)
    val test2 = new testCaseClass("2", 2)
    val test3 = new testCaseClass("3", 2)
    val test4 = new testCaseClass("4", 2)

    val uniqRes = (test1 :: test2 :: test3 :: test4 :: Nil).
      groupBy(testClass => testClass.y).
      map(testClass => testClass._2.head)
    uniqRes.foreach(testClass => println(testClass))
    // testCaseClass(1, 1)
    // testCaseClass(2, 2)

    println("-----------------------------")

    //функции свертки
    println("demo collection folds")
    val demoCollection3 = 1::2::3::4::Nil
    println(s"fold result: ${demoCollection3.fold(0)((z,i) => z + i)}")  // fold result: 10

    // свертка слева-направо
    println(s"foldLeft result: ${demoCollection3.foldLeft(0)((z,i) => z + i)}") // foldLeft result: 10

    // выполним задачу: создадим список списков и выведем те списки, где сумма элементов больше 10
    val testSum = List(1,2,3,4,5) :: List(1,50,3) :: List(1,2) :: Nil
    testSum.filter(x => x.sum > 10).foreach(x => println(x.mkString(",")))
    // "1,2,3,4,5"
    // "1,50,3"

    //реализуем flatMap

    /**
     * Function преобразует String to Integer
     * @param str - String
     * @return - Integer
     */
    def parseInt(str: String): Option[Int] = {
      try {
        Some(str.toInt)
      } catch {
        case _: NumberFormatException => None
      }
    }

    /**
     * Function делит число пополам
     * @param num - Integer
     * @return - num / 2
     */
    def divideByTwo(num: Int): Option[Int] = {
      if (num % 2 == 0) Some(num / 2)
      else None
    }

    val input: String = "8"
    println(parseInt(input).flatMap(divideByTwo)) // Some(4)

    val input1: String = "8sjdfh"
    println(parseInt(input1).flatMap(divideByTwo)) // None

  }

}





















