package proginscala

object Chapter1 extends App {

  // 1.1 A language that grows on you
  var capital = Map("US" -> "Washingto", "France" -> "Paris")
  capital += ("Japan" -> "Tokyo")
  println(capital("France"))

  def factorial(x: BigInt): BigInt =
    if (x == 0) 1 else x * factorial(x - 1)

  println(factorial(30))

  val name = "DavidZhou"
  val nameHasUpperCase = name.exists(_.isUpper)
  println(nameHasUpperCase)

}
