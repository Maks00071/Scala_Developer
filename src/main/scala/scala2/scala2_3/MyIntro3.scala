package scala2.scala2_3

object MyIntro3 extends App{
  val dog = new Dog("dog3 test", 1, "red")
  dog.makeSound() // Gav-Gav!

  val cat = new Cat("cat test", 1, "white")
  cat.makeSound()
  
  val animals: List[Animal] = List(dog, cat)
}



class Animal(val name: String, val age: Int) {
  def makeSound(): Unit = {
    println("generic sound")
  }
}

class Dog(name: String, age: Int, color: String) extends Animal(name, age) {
  override def makeSound(): Unit = {
    println("Gav-Gav!")
  }
}


class Cat(name: String, age: Int, color: String) extends Animal(name, age) {
  override def makeSound(): Unit = {
    println("Mav-Mav!")
  }
}


























