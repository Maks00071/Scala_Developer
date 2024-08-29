package scala.scala2_4

trait Haslegs {
  def walk(): Unit = println("walking on legs")
}

trait HasWings {
  def fly(): Unit
}

class Animal(val name: String) {
  def makeSound(): Unit = {
    println("generic sound")
  }
}

class Dog(name: String) extends Animal(name) with Haslegs {
  override def makeSound(): Unit = {
    println("Gav")
  }
}

class Bird(name: String) extends Animal(name) with HasWings {
  override def fly(): Unit = {
    println(s"$name is flying")
  }

  override def makeSound(): Unit = {
    println(".....")
  }

  def test(): Unit = {
    fly()
    makeSound()
  }
}

object intro3 extends App{
  val dog = new Dog("test")
  dog.makeSound()
  dog.walk()

  val bird = new Bird("Tweety")
  bird.makeSound()
  bird.fly()
  bird.test()
}
