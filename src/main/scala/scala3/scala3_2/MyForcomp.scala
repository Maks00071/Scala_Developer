package scala3.scala3_2

object MyForcomp {
  def main(args: Array[String]): Unit = {
    val RGB = Seq("R", "G", "B")
    val range = Range(1, 4)
    val map = Map("R"->"Red", "G"->"Green", "B"->"Blue")

    //перечисление коллекции в цикле
    for (el <- RGB) {
      println(el)
    }

    println("-------------------------")

    // перечисление двух коллекций в цикле
    for (el <- RGB; el1 <- range) {
      println(s"$el $el1") // комбинации все возможных пар коллекций
    }

    println("-------------------------")

    // обход коллекции Map
    for ((key, value) <- map) {
      println(s"$key $value")
    }

    println("-------------------------")

    // пройдем трижды коллекцию и выведем всевозможные пары
    for (
      el1 <- RGB;
      el2 <- RGB;
      el3 <- RGB
    ){
      println(s"$el1 $el2 $el3")
    }

    println("-------------------------")

    // найдем все уникальные элементы
    for (
      el1 <- RGB;
      el2 <- RGB;
      el3 <- RGB;
      if el1 != el2;
      if el3 != el2 && el3 != el1
    ){
      println(s"$el1 $el2 $el3")
    }

    println("-------------------------")
    println("example")

    // создадим класс машин
    case class Car(marke: String, model: String, year: Int)

    // создадим коллекцию машин
    val cars = Car("VW", "Passat", 2005) :: Car("Lexus", "Ux", 2019) :: Car("BMW", "ix4", 2023) :: Nil

    // создадим класс гаражей
    case class Garage(name: String, index: Int)
    val garages = Garage("BMW", 1) :: Garage("Lexus", 2) :: Nil

    garages.flatMap{
      garage =>
        cars.filter(car => car.marke == garage.name).map(car => (car.marke, car.model, garage.index))
    }.foreach{case (marke, garage, index) => println(s"$marke, $garage $index")}
    /*
      BMW, ix4 1
      Lexus, Ux 2
     */

    println("-------------------------")

    println("for comp.")

    val cars2000 = for {
      car <- cars if car.year > 2010
    } yield (car.marke, car.model)

    cars2000.foreach(x => println(s"${x._1} ${x._2}"))

    println("-------------------------")

    val car1 = for {
      car <- cars       // cars = Car("VW", "Passat", 2005) :: Car("Lexus", "Ux", 2019) :: Car("BMW", "ix4", 2023) :: Nil
      garage <- garages // garages = Garage("BMW", 1) :: Garage("Lexus", 2) :: Nil
      if car.marke == garage.name
    } yield {
      (car.marke, car.model, garage.index)
    }

    car1.foreach({
      case (marke, model, index) => println(s"$marke, $model, $index")  // case дает имена переменным
    })
    /*
      Lexus, Ux, 2
      BMW, ix4, 1
     */
    
    // << Законы Монады >>
    
    // 1. unit(a).flatMap(f) == f(a)
    // 2. ma.flatMap(unit) == ma
    // 3. ma.flatMap(f).flatMap(g) == ma.flatMap(x => f(x).flatMap(g))
  }
}





















