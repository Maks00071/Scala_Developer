package scala2.scala2_5

object MyFunctions extends App{

  // pure function
  val add = (x: Int, y: Int) => { x + y }
  println(add(3, 4))

  def applyOperation(a: Int, b: Int, operation: (Int, Int) => Int): Int = {
    operation(a, b)
  }

  val result = applyOperation(5, 3, add)
  println(result)


  val numbers = List(1, 2, 3, 4, 5)
  val newNumbers = numbers.map(_ * 2)
  println(numbers)  // List(1, 2, 3, 4, 5)
  println(newNumbers) // List(2, 4, 6, 8, 10)

  // функциональные комбинации
  def applyTwice(f: Int => Int, x: Int): Int = {
    f(f(x))
  }

  val increment = (x: Int) => x + 1
  println(applyTwice(increment, 5))  // 7


}


















