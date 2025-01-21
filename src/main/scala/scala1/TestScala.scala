package scala1

import scala.annotation.tailrec

object TestScala extends App {
  //1. int
  val number: Int = 42

  //2. double
  val pi: Double = 3.14

  //3. boolean
  val isFlag: Boolean = true

  //4. char
  val letter: Char = 'A'

  //5. String
  val str: String = "test"

  //Functions
  // Unit
  def printHello(): Unit = println("Hello")

  //Any, AnyVal, AnyRef, Option
  val maybeValue: Option[Int] = Some(42)
  val noValue: Option[Int] = None

  println(maybeValue) // => Some(42)
  println(noValue)  // => None

  //operations
  val sum = 1 + 2 // - * / %

  //equals
  val isEqual: Boolean = 1 == 1  // true
  val isLessOrEqual: Boolean = 2 <= 3

  //logical operations
  val andResult: Boolean = true && false  // => false
  val orResult: Boolean = true || false   // => true
  val notResult: Boolean = !true          // => false


  var x: Int = 10
  x += 5  // x = 15
  x -= 3  // x = 12


  //if else
  val a: Int = 5
  val b: Int = 10
  val max: Int = if (a > b) a else b
  println(max)  // => 10



  //cycles
  var j: Int = 0

  while (j < 5) {
    println(3)
    j += 1
  }

  println("------------------------------")

  for (i <- 1 to 10) {
    println("i = " + i)
  }

  println("------------------------------")

  for (i <- 1 to 10 if (i % 2 == 0)) {
    println("i = " + i)
  }

  //generate collections
  val coll = for (i <- 1 to 5) yield i * 2
  println(coll) // => Vector(2, 4, 6, 8, 10)


  //Functions and Methods
  def add(a: Int, b: Int): Int = {
    return a + b
  }

  val sumTwo = add(3, 5)
  println(sumTwo)   // => 8

  def greet(): String = {
    return "hello!"
  }

  val greetVal = greet()
  println(greet())  // => hello!
  println(greetVal) // => hello!

  def printMessage(msg: String): Unit = {
    println(msg)
  }
  printMessage("This is a message!")  // => This is a message!

  println("----------------- value -------------")

  //value
  def increment(x: Int): Int = {
    return x + 1
  }

  val number2: Int = 5
  val incNumber = increment(number2)
  println(incNumber)  // 6

  println("---------------- ref --------------")

  //ref
  class Counter(var count: Int)

  def incCounter(counter: Counter): Unit = {
    counter.count += 1
  }

  val myCounter = new Counter(1)
  incCounter(myCounter)
  println(myCounter.count)  // => 2

  println("---------------- recursion --------------")

  //recursion
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }
  println(factorial(5)) // => 120

  println("---------------- tail recursion --------------")

  //можно так создать коллекцию
  val test1 = List("1", "2", "3")
  println(test1)    // => List(1, 2, 3)

  //а можно так
  val test2 = "1" :: "2" :: "3" :: Nil
  println(test2)    // => List(1, 2, 3)
}

object TailRecursion {
  def main(args: Array[String]): Unit = {
    val test = List("1", "2", "3")
    println(s"size is ${tailRec(test, 0L)}")   // => size is 3
  }

  @tailrec
  def tailRec(list: List[String], accum: Long): Long = list match {
    case Nil => accum // если пришел null, т.е. последний элемент
    case head :: tail => tailRec(tail, accum + 1)
  }
}































