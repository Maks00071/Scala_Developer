package scala.scala2_4

object intro4 extends App{
  // pure function
  val add = (x: Int, y: Int) => { x + y }
  def applyOperation(a: Int, b: Int, operation: (Int, Int) => Int): Int ={
    operation(a, b)
  }

  println(add(3,4))
  val result = applyOperation(5,3, add)
  println(result)


  val numbers = List(1,2,3,4,5)
  val newNumbers = numbers.map(_ * 2)
  println(numbers)
  println(newNumbers)

  def applyTwice(f: Int => Int, x: Int): Int ={
    f(f(x))
  }

  val increment = (x: Int) => x + 1
  println(applyTwice(increment, 5))



}
