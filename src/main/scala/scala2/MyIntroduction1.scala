package scala2

class MyIntroduction1 {
}

class Person(val name: String, val age: Int) {
  def greet(): String = s"hi, I am $name and I $age years old"
}

// объект-компаньен
object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)
}

// Pattern Singleton
object Singelton{
  def greet(): String = "test"
}

// Pattern Factory
class Car(val model: String, val year: Int) {
}

object Car {
  def createCar(model: String): Car = new Car(model, 1955)
}

// inheritance (наследование)
class Animal(val name: String) {
  def makeSound(): Unit = {
    println("some generic animal sound")
  }
}

class Dog(name: String) extends Animal(name) {
  override def makeSound(): Unit = {
    super.makeSound() // вызываем метод родителя
    println("Gav") // переопределяем метод родителя
  }
}





object Main extends App {
  val person = new Person("Alice", 30)

  println(person.age)
  println(person.name)
  println(person.greet())
  println(Singelton.greet())

  val person1 = Person("Bob", 12)
  println(person1.age)
  println(person1.name)

  val oldCar = Car.createCar("VW")
  println(s"car: ${oldCar.model}, year: ${oldCar.year}")

  val genericAnimal = new Animal("Animal test")
  val dog = new Dog("Dog test")
  dog.makeSound() //"Gav"
}

























