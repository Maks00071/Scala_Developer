package scala.scala3

import scala.collection.immutable

object collections {
  def main(args: Array[String]): Unit = {
    val demoCollection1: immutable.Seq[String] = "line 1" :: "line 2" :: "line 3" :: Nil
    val demoCollection2 = List("line 1", "line 2", "line 3")

    val demoSet = ("line 1" :: "line 2" :: "line 3" :: "line 3" :: Nil).toSet
    demoSet.foreach(x => println(x))

    ("line 1" :: "line 2" :: "line 3" :: "line 3" :: Nil).groupBy(x=>x).map(x => x._1).foreach(x => println(x))
    case class testcaseclass(x: String, y:Int)
    val test1 = new testcaseclass("1", 1)
    val test2 = new testcaseclass("2", 2)
    val test3 = new testcaseclass("3", 2)
    val test4 = new testcaseclass("4", 2)

    println("________________________")
    val uniqRes = (test1 :: test2 :: test3 :: test4 :: Nil).groupBy(testclass => testclass.y).map(testclass=> testclass._2.head)
    uniqRes.foreach(uu => println(uu))

    println("demo collection folds")
    val demoColelction = 1::2::3::4::Nil
    println(s"fold result: ${demoColelction.fold(0)((z,i) => z + i)}")
    println(s"fold left result: ${demoColelction.foldLeft(0)((z,i) => z + i)}")
    println(s"fold right result: ${demoColelction.foldRight(0)((z,i) => z + i)}")

    val test = List(1,2,3,4,5) :: List(1,50,3) :: List(1,2) :: Nil
    test.filter(x => x.sum > 10).foreach(x => println(x.mkString(",")))

    def parseInt(str: String): Option[Int] = {
      try {
        Some(str.toInt)
      } catch {
        case _: NumberFormatException => None
      }
    }

    def divideByTwo(num: Int): Option[Int] = {
      if (num %2  == 0) Some(num / 2)
      else None
    }

    val input: String = "8"
    println(parseInt(input).flatMap(divideByTwo))
    val input1: String = "8dcx"
    println(parseInt(input1).flatMap(divideByTwo))




  }
}
