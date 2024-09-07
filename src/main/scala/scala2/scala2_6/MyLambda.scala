package scala2.scala2_6

object MyLambda extends App{

  // (parameters) => expression

  val add = (x: Int, y: Int) => x + y
  val greet = () => println("Hi!")
  greet() // Hi!


  val numbers = List(1, 2, 3, 4, 5)
  val doubled = numbers.map(x => x * 2)
  println(doubled)  // List(2, 4, 6, 8, 10)

}


























