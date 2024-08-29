package scala.scala2_5

object intro5 extends App{
  // (parameters) => expression

  val add = (x: Int, y:Int) => x+y
  val greet = () => println("Hi")
  greet()

  val numbers = List(1,2,3,4,5)
  val doubled = numbers.map(x=>x*2)
  println(doubled)

}
