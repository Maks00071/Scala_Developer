package scala2.scala2_2

abstract class Animal2(val name: String) {
  def makeSound(): Unit
}

class Dog2(name: String) extends Animal2(name) {
  override def makeSound(): Unit = {
    println("Gav")
  }
}


object MyIntro3 {
  def main(args: Array[String]): Unit = {
    val dog1 = new Dog2("test")
    dog1.makeSound() // "Gav"
  }
}
