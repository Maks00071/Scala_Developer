package scala2.scala2_3

abstract class Animal2(val name: String, val age: Int) {
  def makeSound(): Unit = {
    println("generic sound")
  }
}

class Dog2(name: String, age: Int, val color: String) extends Animal2(name, age) {
  override def makeSound(): Unit = {
    println("Gav-Gav")
  }
}

class Cat2(name: String, age: Int, val color: String) extends Animal2(name, age) {
  override def makeSound(): Unit = {
    println("Mayu-Mayu")
  }
}


object MyIntro3_3 {
  def main(args: Array[String]): Unit = {
    val dog = new Dog2("dog", 5, "white")
    dog.makeSound()

    val cat = new Cat2("cat", 4, "gray")
    cat.makeSound()
  }
}






















