package scala.scala2

class Person(val name: String, val age: Int) {
  def greet(): String = s"hi, i am $name and i am $age years old"
}

object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)
}

object Singelton{
  def greet(): String = "test"
}
// pattern factory
class Car(val model: String, val year: Int)

object Car {
  def createCar(model: String): Car = new Car(model, 1955)
}

// inheritance
class Animal(val name: String){
  def makeSound(): Unit = {
    println("some generic animal sound")
  }
}

class Dog(name: String) extends Animal(name) {
  override def makeSound(): Unit = {
    super.makeSound()
    println("Gav")
  }
}


object Main extends App {
/*  val person = new Person("Alice", 30)

  println(person.age)
  println(person.name)
  println(person.greet())
  println(Singelton.greet())*/

  val person = Person("Bob", 12)
  println(person.age)
  println(person.name)

  val oldCar = Car.createCar("Vw")
  println(s"car: ${oldCar.model} year: ${oldCar.year}")

  val genericAnimal = new Animal("test")
  val dog = new Dog("test1")
  dog.makeSound()
}

