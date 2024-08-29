package scala.scala2_6

object intro6 extends App{

  def greet(name: String)(implicit greeting: Int): Unit ={
    println(s"$greeting, $name")
  }

  implicit val defGreeting: String = "DEF"
  implicit val defGreeting1: Int = 6

  greet("test")
}


object ImplicitConversionExample extends App {
  implicit def intToString(x: Int): String = x.toString

  def printString(s: String): Unit = {
    println(s)
  }

  printString(42)
}


object ImplicitClassesExample extends App {
  implicit  class IntOps(x: Int) {
    def square: Int = x*x
  }

  println(5.square)
}

object ImplicitObjectsExample extends App {
  trait Show[A] {
    def show(a: A): String
  }

  implicit object IntShow extends Show[Int] {
    def show(a: Int): String = s"Int: $a"
  }
  implicit object StringShow extends Show[String] {
    def show(a: String): String = s"String: $a"
  }

  def printShow[A](a: A)(implicit  s: Show[A]): Unit = {
    println(s.show(a))
  }

  printShow(42)
  printShow("42")
}