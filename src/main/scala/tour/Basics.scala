package tour

/**
  * http://docs.scala-lang.org/tour/basics.html.
  */

// Classes
// class keyword followed by its name and constructor parameters
class Greeter(prefix: String, suffix: String) {

  // The return type is Unit, similar to void in Java
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}


// Case Classes.
// By default, case classes are immutable and compared by value.
// You can instantiate case calsses without new keyword.
case class BasicPoint(x: Int, y: Int)

// Objects
// Objects are single instances of their own definitions.
// Singletons of their own classes.
// You can access an object by referring to its name.
object IdFactory {
  private var counter = 0

  def create(): Int = {
    counter += 1
    counter
  }
}


// Traits
// Traits are types containing certain fields and methods.
// Multiple traits can be combined.
trait GreeterTraits {
  def greet(name: String): Unit
}

// Traits can also have default implementations.
trait GreeterTraits2 {
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
}

// You can extends traits with extends keyword and override an implementation
// with the override keyword.
// It could extend multiple traits.
class DefaultGreeter extends GreeterTraits2

class CustomizableGreeter(prefix: String, postfix: String) extends GreeterTraits2 {
  override def greet(name: String): Unit = {
    println(prefix + name + postfix)
  }
}

// Main Method - an entry point of a program.
object Main {
  def main(args: Array[String]): Unit =
    println("Hello, Scala developer!")
}

object Basics extends App {

  // Blocks
  // the result of the last expression in the block is the result of the overall block.
  println({
    val t = 4 + 5
    t + 6
  })

  // Functions - Functions are expressions that take parameters.
  val addOne = (x: Int) => x + 1
  println(addOne(1))

  // Functions may take multiple parameters
  //  val add = (x: Int, y: Int) => x + y
  //  println(add(1, 2))

  // Function may take no parameters
  val getTheAnswer = () => 42
  println(getTheAnswer())

  // Methods
  // Methods are defined with the def keyword.
  // def is followed by a name, parameter lists, a return type, and a body
  def add(x: Int, y: Int): Int = x + y

  println(add(1, 2))

  // Methods can take multiple parameter lists
  def addThenMultiply(x: Int, y: Int)(a: Int, b: Int): Int = (x + y) * (a + b)

  println(addThenMultiply(1, 2)(3, 4))

  // Method with no parameter list
  def name: String = System.getProperty("user.name")

  println("Hello " + name + "!")

  // Method with multi-line expression
  // the last expression in the body is the method's return value.
  // Scala does have a return keyword, but it's rarely used.
  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }

  println(getSquareString(5.0d))

  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer")

  val point = BasicPoint(1, 2)
  val anotherPoint = BasicPoint(1, 2)
  val yetAnotherPoint = BasicPoint(2, 2)

  println("point == anotherPoint is " + (point == anotherPoint))
  println("point == yetAnotherPoint is " + (point == yetAnotherPoint))

  // You can access an object by referring to its name.
  val newId: Int = IdFactory.create()
  println(newId)

  val newerId: Int = IdFactory.create()
  println(newerId)

  val greeterTraits = new DefaultGreeter()
  greeterTraits.greet("Scala developer")

  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer")


}


