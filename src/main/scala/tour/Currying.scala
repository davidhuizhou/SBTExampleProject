package tour

/**
  * Methods may define multiple parameter lists.
  * When a method is called with a fewer number of parameter lists,
  * then this will yield a function taking the missing parameter lists as its arguments.
  * This is formally known as currying.
  */
object Currying extends App {
  // Here is an example, defined in Traversable trait from Scala collections:
  // def foldLeft[B](z: B)(op: (B, A) => B): B

  // Starting with an initial value of 0, foldLeft here applies
  // the function (m, n) => m + n to each element in the List
  // and the previous accumulated value.
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((m, n) => m + n)
  println(res)

  // Note that the use of multiple parameter lists here also allows us to take advantage of
  // Scala type inference to make the code more concise as shown below; which would not be
  // possible in a non-curried definition.
  println(numbers.foldLeft(0)(_ + _))

  // Also, it allows us to fix the parameter z and pass around
  // a partial function and reuse it as shown below:
  val numberFunc = numbers.foldLeft(List[Int]()) _

  val squares = numberFunc((xs, x) => xs :+ x * x)
  println(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

  val cubes = numberFunc((xs, x) => xs :+ x * x * x)
  println(cubes.toString()) // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)

}
