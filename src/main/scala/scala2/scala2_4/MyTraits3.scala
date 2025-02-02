package scala2.scala2_4

object MyTraits3 {
  def main(args: Array[String]): Unit = {
    val dog1 = new Dog3("Sharik", 5)
    dog1.makeSound()
    dog1.walk()

    val bird1 = new Bird3("Tweety", 1)
    bird1.makeSound()
    bird1.fly()
    bird1.combyFunc()
  }
}

trait Haslegs3 {
  def walk(): Unit = {
    println("walking on legs")
  }
}

trait HasWings3 {
  def fly(): Unit
}

class Animal3(val name: String, val age: Int) {
  def makeSound(): Unit = {
    println("generic sound")
  }
}

class Dog3(name: String, age: Int) extends Animal3(name, age) with Haslegs3 {
  override def makeSound(): Unit = {
    println("gav-gav-gav")
  }
}

class Bird3(name: String, age: Int) extends Animal3(name, age) with HasWings3 {
  override def fly(): Unit = {
    println(s"The Bird ${name} ${age} is flying")
  }

  override def makeSound(): Unit = {
    println("..........")
  }

  def combyFunc(): Unit = {
    fly()
    makeSound()
  }
}


































