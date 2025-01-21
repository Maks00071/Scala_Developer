package scala2.scala2_5

object NewMyFunctions extends App {

  // pure function
  val add = (x: Int, y: Int) => { x + y}
  println(add(3, 4)) // 7

  def applyOperation(a: Int, b: Int, operation: (Int, Int) => Int): Int = {
    operation(a, b)
  }
  val sumResult = applyOperation(5, 3, add)
  println(sumResult) // 8

  val numbers = List(1, 2, 3, 4, 5)
  val newNumbers = numbers.map(_ * 2)
  println(numbers)    // List(1, 2, 3, 4, 5)
  println(newNumbers) // List(2, 4, 6, 8, 10)

  // функциональные комбинации
  def applyTwice(f: Int => Int, x: Int): Int = {
    f(f(x))
  }

  val incrementFunc = (x: Int) => x + 1
  println(applyTwice(incrementFunc, 5)) // 7
}






























