package tour

/**
  * In Scala it is possible to nest method definitions.
  */
object NestedFunctions extends App {

  // The following object provides a factorial method for computing
  // the factorial of a given number:
  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }

    fact(x, 1)
  }

  println("Factorial of 2: " + factorial(2))
  println("Factorial of 3: " + factorial(3))

}
