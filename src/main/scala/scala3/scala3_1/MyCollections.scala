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

    val uniqRes = (test1 :: test2 :: test3 :: test4 :: Nil).groupBy(testClass => testClass.y).map(testClass => testClass._2.head)
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

  }

}






















