package scala2.scala2_7

import scala.language.implicitConversions


object MyImplicit extends App{

  def greet(name: String)(implicit greeting: String): Unit = {
    println(s"$greeting, $name")
  }

  //greet("this is name")("this is greeting") // "this is greeting, this is name"

  implicit val defGreeting: String = "DEF"
  greet("this is name") // "DEF, this is name"

}



object ImplicitConversionExample extends App{

  implicit def intToString(x: Int): String = x.toString

  def printString(s: String): Unit = {
    println(s)
  }

  printString(42) // "42"
}


object ImplicitClassesExample extends App{

  implicit class IntOps(x: Int) {
    def square: Int = x * x
  }

  println(5.square) // 25
}


object ImplicitObjectsExample extends App{
  trait Show[A] {
    def show(a: A): String
  }
  
  implicit object IntShow extends Show[Int] {
    def show(a: Int): String = s"Int $a"
  }
  
  implicit object StringShow extends Show[String] {
    def show(str: String): String = s"String $str"
  }
  
  def printShow[A](a: A)(implicit s: Show[A]): Unit = {
    println(s.show(a))
  }
  
  printShow(24)
  printShow("24")
}






















