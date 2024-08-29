package scala.scala2_2

class Animal(val name: String, val age: Int) {
  def makeSound(): Unit = {
    println("generic sound")
  }
}

class Dog(name: String, age: Int, color: String) extends Animal(name,age) {
  override def makeSound(): Unit = {
    println("Gav")
  }
}

class Cat(name: String, age: Int, color: String) extends Animal(name,age) {
  override def makeSound(): Unit = {
    println("Mav")
  }
}

object intro2 extends App{
  val dog = new Dog("test", 1, "red")
  val cat = new Dog("test", 1, "red")

  val animals: List[Animal] = List(dog, cat)


}
