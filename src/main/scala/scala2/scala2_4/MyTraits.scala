package scala2.scala2_4

object MyTraits extends App{
  val dog = new Dog("Sharik", 3)
  dog.makeSound()
  dog.walk()

  val bird = new Bird("Tweety", 2)
  bird.fly()
  bird.makeSound()
  bird.combyFunc()
}


trait Haslegs {
  def walk(): Unit = println("walking on legs")
}

trait HasWings {
  def fly(): Unit
}

class Animal(val name: String, val age: Int) {
  def makeSound(): Unit = {
    println("generic sound")
  }
}


class Dog(name: String, age: Int) extends Animal(name, age) with Haslegs {
  override def makeSound(): Unit = {
    println("Gav - Gav - Gav!")
  }
}

class Bird(name: String, age: Int) extends Animal(name, age) with HasWings {
  override def fly(): Unit = {
    println(s"$name $age is flying!")
  }

  override def makeSound(): Unit = {
    println("........")
  }

  def combyFunc(): Unit = {
    fly()
    makeSound()
  }
}

















