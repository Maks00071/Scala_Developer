package scala1
import scala.annotation.tailrec


object scalaIntro1 extends App {
  //1. int
  val number: Int = 42
  
  //2. double
  val pi: Double = 3.14
  
  //3. boolean
  val isFlag: Boolean = true
  
  //4. char
  val letter: Char = 'A'
  
  //5. strings
  val str: String = "test"

  def printHello(): Unit = println("hello")
  // Any, AnyVal, AnyRef, Option
  val maybeValue: Option[Int] = Some(42)
  val noValue: Option[Int] = None

  //operations
  val sum = 1 + 2 // / * %

  // eqv
  val isEqual: Boolean = 1 == 1
  val isLessorEqual = 2 <= 3

  //logical
  val andResult = true && false
  val orResult = true || false
  val notResult = !true // false


  var x = 10
  x += 5 //15
  x -= 3 // 12

  // if else

  val a = 5
  val b = 10
  val max = { if (a>b) a else b }

  // cycles
  var j = 0
  
  while (j < 5) {
    println(3)
    j += 1
  }

  for (i <- 1 to 5) {
    println(i)
  }

  for (i<-1 to 10 if i % 2 == 0) {
    println(i)
  }

  val double = for (i <- 1 to 5) yield i * 2
  println(double)

  // functions
  def add(a: Int, b: Int): Int = {
    a + b
  }

  val sum1 = add(3,5)
  println(sum1)

  def greet(): String = {
    "hello"
  }
  println(greet())

  def printMessage(msg: String): Unit = {
    println(msg)
  }
  printMessage("sdfg")

  //val
  def inc(x: Int): Int = {
    x+1
  }

  val number1 = 5
  val incNumber = inc(number1) // 6

  // ref
  class Counter(var count:Int)

  def incCounter(counter: Counter): Unit = {
    counter.count += 1
  }

  val myCounter = new Counter(1)
  incCounter(myCounter)
  println(myCounter.count) // 2

  def factorial(n:Int): Int = {
    if (n == 0) 1
    else n *factorial(n-1)
  }
}


object TailRec {
  def main(args: Array[String]): Unit = {
    val test = List("1", "2", "3")
    println(s"size is ${tailRec(test, 0)}")
  }

  @tailrec
  def tailRec(list: List[String], accum: Long): Long = list match {
    case Nil => accum
    case head :: tail => tailRec(tail, accum +1)
  }

}