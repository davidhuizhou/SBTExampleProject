package proginscala

object Chapter5 extends App {

  val hex = 0x5
  val hex2 = 0x00FF

  // Long
  val prog = 35L
  val little: Short = 367
  val litter: Byte = 38

  // Float
  val littleF = 1.2345F
  val littleBigger = 3e5f

  // Double
  val anotherDouble = 3e5
  val yetAnother = 3e5D

  // String literals
  val escapes = "\\\"\'"

  // print out a message using raw string
  println(
    """Welcome to Ultamix 3000.
             Type "HELP" for help.""")

  println(
    """|Welcome to Ultamix 3000.
       |Type "HELP" for help.""".stripMargin)


  // Symbol literals

  // A symbol literal is written 'ident, where ident can be any alphanumeric identifier.
  // Such literals are mapped to instances of the predefined class scala.Symbol.
  // Specifically, the literal 'cymbal will be expanded by the compiler to a factory
  // method invocation: Symbol("cymbal").
  // Symbol literals are typically used in situations where you would use just an identifier
  // in a dynamically typed language. For instance, you might want to define a method that
  // updates a record in a database:

  def updateRecordByName(r: Symbol, value: Any) = {
    // code goes here
    println(r.name)
  }

  updateRecordByName('favoriteAlbum, "OK Computer")

  // 5.3 String interpolation

  // embed expressions within string literals
  val name = "reader"
  println(s"Hello, $name!")

  // You can place any expression after a dollar sign ($) in a processed string literal.
  println(s"The answer is ${6 * 7}.")

  // Scala provides two other string interpolators by default: raw and f.

  // The raw string interpolator behaves like s, except it does not recognize character literal
  // escape sequences
  println(raw"No\\\\escape!") // prints: No\\\\escape!

  // The f string interpolator allows you to attach printf-style formatting instructions to
  // embedded expressions. You place the instructions after the expression,
  // starting with a percent sign (%), using the syntax specified by java.util.Formatter.
  println(f"${math.Pi}%.5f")

  // If you provide no formatting instructions for an embedded expression, the f string
  // interpolator will default to %s, which means the toString value will be substituted,
  // just like the s string interpolator
  val pi = "Pi"
  println(f"$pi is approximately ${math.Pi}%.8f.")


}
