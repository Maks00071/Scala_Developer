package scala1

import scala.annotation.tailrec


object NewScala1 extends App {
  // int
  val number: Int = 56

  // double
  val pi: Double = 3.14

  // boolean
  val isFlag: Boolean = true

  // char
  val letter: Char = 'A'

  // String
  val srt: String = "test"

  // function
  def printHello(): Unit = println("Hello!")
  printHello()

  // Any, AnyVal, AnyRef, Option
  val maybeValue: Option[Int] = Some(42)
  val noValue: Option[Int] = None

  println(maybeValue)
  println(noValue)

  //operations
  val sum = 1 + 2
  println(sum)

  // equals
  val isEqual: Boolean = 1 == 1
  println(isEqual)

  val isLessOrEqual: Boolean = 2 <= 3
  println(isLessOrEqual)

  // logical operations
  val andResult: Boolean = true && false
  println(andResult)
  val orResult: Boolean = true || false
  println(orResult)
  val notResult: Boolean = !true
  println(notResult)

  var x: Int = 10
  x += 5
  x -= 3
  println(x)

  // if else
  val a: Int = 5
  val b: Int = 10
  val max: Int = if (a > b) a else b
  println(max)

  // cycles
  var j: Int = 0

  while (j < 5) {
    print(3)
    j += 1
  }

  println("\n------------------------------------")

  for (i <- 1 to 10) {
    println("i = " + i)
  }

  println("------------------------------------")

  for (i <- 1 to 10 if (i % 2 == 0)) {
    println("i = " + i)
  }

  println("------------------------------------")

  // generate collections
  val coll = for (i <- 1 to 5) yield i*2
  println(coll)

  // functions and methods
  def add(a: Int, b: Int): Int = {
    return a + b
  }
  val sumTwoNumbers = add(3, 5)
  println(sumTwoNumbers)

  def greet(): String = {
    return "Hello!"
  }
  val greetVal: String = greet()
  println(greetVal)
  println(greet())

  def printMessage(msg: String): Unit = {
    println(msg)
  }
  printMessage("This is a message!")

  println("----------------- value -------------")

  // value
  def increment(x: Int): Int = {
    return x + 1
  }
  val number2: Int = 5
  val incNumber: Int = increment(5)
  println(incNumber)

  println("---------------- ref --------------")

  // ref
  class Counter(var count: Int)

  def incCounter(counter: Counter): Unit = {
    counter.count += 1
  }
  val myCounter = new Counter(1)
  println(myCounter.count) // 1
  incCounter(myCounter)
  println(myCounter.count) // 2

  println("---------------- recursion --------------")

  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }
  println(factorial(5)) // 120

  val testList = List("1", "2", "3")
  println(testList) // List(1, 2, 3)

  val testListAnother = "1" :: "2" :: "3" :: Nil
  println(testListAnother) // List(1, 2, 3)
}



// tailrecursion
 object TailRecursionV2 {
  def main(args: Array[String]): Unit = {
    println("---------------- tail recursion --------------")
    val test = List("1", "2", "3")
    println(s"size is ${tailRecurs(test, 0L)}")
  }

  @tailrec
  def tailRecurs(list: List[String], accum: Long): Long = list match {
    case Nil => accum
    case head :: tail => tailRecurs(tail, accum + 1)
  }
}

















