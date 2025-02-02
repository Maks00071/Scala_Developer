package scala2.scala2_1

import scala.*

object MyIntroduction1_3 {
  def main(args: Array[String]): Unit = {
    val person = new Person("Alice", 30)
    println(person.name) // Alice
    println(person.age) // 30
    println(person.greet()) // "hi, I am Alice and I 30 years old"

    val person2 = Person("Bob", 27)
    println(person2.name) // Bob
    println(person2.age) // 27
    println(person2.greet()) // "hi, I am Bob and I 27 years old"

    println(Singleton2.greet()) // "This is a Singleton!"

    val oldCar = Car2.createCar("VW")
    println(s"car: ${oldCar.model}, year: ${oldCar.year}") // "car: VW, year: 1955"

    val someAnimal = new Animal3("someAnimal")
    val someDog = new Dog3("someDog")
    someDog.makeSound()
  }
}

class Person2(val name: String, val age: Int) {
  def greet(): String = s"Hi, I'm ${name} and I'm ${age} years old"
}

object Person2 {
  def apply(name: String, age: Int): Person = new Person(name, age)
}

object Singleton2 {
  def greet(): String = "This is a Singleton!"
}

class Car2(val model: String, val year: Int) {
}

object Car2 {
  def createCar(model: String): Car2 = new Car2(model, 1955)
}


class Animal3(val name: String) {
  def makeSound(): Unit = {
    println("I'm a sound of an animal!")
  }
}

class Dog3(name: String) extends Animal3(name) {
  override def makeSound(): Unit = {
    super.makeSound()
    println("I'm a sound of a dog! ")
  }
}






















