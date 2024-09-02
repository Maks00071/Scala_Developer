package scala2.scala2_2


// Abstract Class
abstract class Animals(val name: String) {
  def makeSound(): Unit
}

class Dog(name: String) extends Animals(name) {
  def makeSound(): Unit = {
    println("Gav")
  }
}


object MyIntro2 extends App {
  val dog = new Dog("Dog Test!")
  dog.makeSound()
}