package scala.scala3

object forcomp {
  def main(args: Array[String]): Unit = {
    val RGB = Seq("R", "G", "B")
    val range = Range(1, 4)
    val map = Map("R" -> "Red", "G" -> "Green", "B" -> "Blue")
    println("_____________")
    for (el <- RGB) {
      println(el)
    }
    println("_____________")
    for (el <- RGB; el1 <- range) {
      println(s"$el $el1")
    }

    println("_____________")
    for ((key, value) <- map) {
      println(s"$key $value")
    }
    println("_____________")

    for (
      el1 <- RGB;
      el2 <- RGB;
      el3 <- RGB
    ){
      println(s"$el1 $el2 $el3")
    }
    println("_____________")
    for (
      el1 <- RGB;
      el2 <- RGB;
      el3 <- RGB;
      if el1 != el2;
      if el3 != el2 && el3 != el1
    ){
      println(s"$el1 $el2 $el3")
    }

    println("example")
    case class Car(marke: String, model: String, year: Int)
    val cars = Car("VW", "Passat", 2005) :: Car("Lexus", "Ux", 2019) :: Car("BMW", "ix4", 2023) :: Nil
    case class Garage(name: String, index: Int)
    val garages = Garage("BMW", 1) :: Garage("Lexus", 2) :: Nil

    garages.flatMap{
      garage =>
        cars.filter(car => car.marke == garage.name).map(car => (car.marke, car.model, garage.index))
    }.foreach{case (m, g, i) => println(s"$m $g $i")}

    println("for comp.")
    val cars2000 = for {
      car <- cars if car.year > 2010
    } yield (car.marke, car.model)

    cars2000.foreach(x=>println(s"${x._1} ${x._2}"))

    println("_____________________________")
    val car1 = for {
      car <- cars
      garage <- garages
      if car.marke == garage.name
    } yield {
      (car.marke, car.model, garage.index)
    }

    car1.foreach({
      case (marke, model, index) => println(s"$marke, $model, $index")
    })
    // unit(a).flatMap(f) == f(a)
    // ma.flatMap(unit) == ma
    // ma.flatMap(f).flatMap(g) == ma.flatMap(x=>f(x).flatMap(g))

  }
}
