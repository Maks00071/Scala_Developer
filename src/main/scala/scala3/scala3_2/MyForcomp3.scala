package scala3.scala3_2

object MyForcomp3 {
  def main(args: Array[String]): Unit = {
    val RGB = Seq("R", "G", "B")
    val range = Range(1,4)
    val map = Map("R"->"Red", "G"->"Green", "B"->"Blue")

    //перечисление коллекции в цикле
    for (el <- RGB) {
      println(el)
    }

    println("---------------------------")

    // перечисление двух коллекций в цикле
    for (el <- RGB; el1 <- range) {
      println(s"${el}, ${el1}")
    }

    println("---------------------------")

    // обход коллекции Map
    for ((key, value) <- map) {
      println(s"${key}: ${value}")
    }

    println("---------------------------")

    // пройдем трижды коллекцию и выведем всевозможные пары
    for (
      el1 <- RGB;
      el2 <- RGB;
      el3 <- RGB
    ) {
      println(s"${el1} ${el2} ${el3}")
    }

    println("---------------------------")

    // найдем все уникальные элементы
    for (
      el1 <- RGB;
      el2 <- RGB;
      el3 <- RGB;
      if el1 != el2;
      if el3 != el1 && el3 != el2
    ) {
      println(s"${el1} ${el2} ${el3}")
    }

    println("---------------------------")

    println("example")

    // создадим класс машин
    case class Car2(marke: String, model: String, year: Int)

    // создадим коллекцию машин
    val cars = Car2("VW", "Passat", 2005) :: Car2("Lexus", "Ux", 2019) :: Car2("BMW", "ix4", 2023) :: Nil

    // создадим класс и коллекцию гаражей
    case class Garage2(name: String, index: Int)
    val garages = Garage2("BMW", 1) :: Garage2("Lexus", 2) :: Nil

    garages.flatMap {
      garage =>
        cars.filter(car => car.marke == garage.name)
          .map(car => (car.marke, car.model, car.year, garage.index))
    }.foreach{case (marke, model, year, index) => println(s"${marke}, ${model}, ${year}, ${index}")}

    /*
    BMW, ix4, 2023, 1
    Lexus, Ux, 2019, 2
     */

    println("---------------------------")

    println("for comp.")

    val cars2010 = for {
      car <- cars if car.year > 2010
    } yield (car.marke, car.model, car.year)

    cars2010.foreach(x => println(s"${x._1}, ${x._2}, ${x._3}"))

    println("-------------------------")

    val car1 = for {
      car <- cars  // cars = Car("VW", "Passat", 2005) :: Car("Lexus", "Ux", 2019) :: Car("BMW", "ix4", 2023) :: Nil
      garage <- garages  // garages = Garage("BMW", 1) :: Garage("Lexus", 2) :: Nil
      if car.marke == garage.name
    } yield (car.marke, car.model, garage.index)

    car1.foreach(x => println(s"${x._1}, ${x._2}, ${x._3}"))

    car1.foreach({
      case (marke, model, index) => println(s"$marke, $model, $index") // case дает имена переменным
    })
  }
}




























