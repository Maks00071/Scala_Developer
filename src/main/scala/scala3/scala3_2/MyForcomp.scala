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
  }

}





















