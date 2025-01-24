package scala2.scala2_7

import scala.language.implicitConversions


object MyImplicit3 {
  def main(args: Array[String]): Unit = {

    def greet(name: String)(implicit greeting: String): Unit = {
      println(s"${greeting}, ${name}")
    }

    // greet("this is name")("this is greeting") // "this is greeting, this is name"
    implicit val defGreetin: String = "this is greeting"
    greet("This is a name")
  }
}


object ImplicitConversionExample3 {
  def main(args: Array[String]): Unit = {

    implicit def intToString(x: Int): String = x.toString

    def printString(s: String): Unit = {
      println(s)
    }

    printString(42)
  }
}


object ImplicitClassesExample3 {
  def main(args: Array[String]): Unit = {

    implicit class IntOps3(x: Int) {
      def square: Int = x * x
    }

    println(5.square) // 25
  }
}


object ImplicitObjectsExample3 {
  def main(args: Array[String]): Unit = {

    trait Show3[A] {
      def show(a: A): String
    }

    implicit object IntShow3 extends Show3[Int] {
      override def show(a: Int): String = s"Int: ${a}"
    }

    implicit object StringShow3 extends Show3[String] {
      override def show(str: String): String = s"String: ${str}"
    }

    def printShow[A](a: A)(implicit s: Show3[A]): Unit = {
      println(s.show(a))
    }

    printShow(24)
    printShow("24")
  }
}










































