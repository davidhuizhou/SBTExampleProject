package example

object Main extends App {
  val ages = Seq(42, 61, 29, 64)
  println(s"The oldest person is ${ages.max}")

  println(1 + 1)
  println("Hello," + " world!")
  val x = 1 + 1
  val y: Int = 1 + 2
  println("y = " + y)

  var z = 1 + 1
  z = 3
  println("z * z = " + z * z)

  println({
    val t = 4 + 5
    t + 6
  })


  val addOne = (x: Int) => x + 1
  println(addOne(1))
}
