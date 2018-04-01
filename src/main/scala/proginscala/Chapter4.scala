package proginscala

import scala.collection.mutable

class ChecksumAccumulator {
  private var sum = 0;

  // 4.1 Classes, fields, and methods

  // One important characteristic of method parameters in Scala
  // is that they are vals, not vars.

  //  def add(b: Byte): Unit = {
  //    // b = 1 // This won't compile, because b is a val
  //    sum += b
  //  }

  // The recommended style for methods is in fact to avoid having explicit,
  // and especially multiple, return statements. Instead,
  // think of each method as an expression that yields one value, which is returned.

  // Another shorthand for methods is that you can leave off the curly braces
  // if a method computes only a single result expression.
  // If the result expression is short, it can even be placed on the same line as the def itself.
  // For the utmost in conciseness, you can leave off the result type and Scala will infer it.
  def add(b: Byte): Unit = sum += b

  //  def checksum(): Int = {
  //    return ~(sum & 0xFF) + 1
  //  }
  //
  def checksum(): Int = ~(sum & 0xFF) + 1
}

// 4.3 Singleton objects

// Scala cannot have static members.  Instead, Scala has single objects.
// When a singleton object shares the same name with a class,
// it is called that class's companion object.
// You must define both the class and its companion object in the same source file.
// The class is called the companion class of the singleton object.
// A class and its companion object can access each other's private members.

// One difference between classes and singleton objects is that singleton objects
// cannot take parameters, whereas classes can.
// Because you can't instantiate a singleton object with the new keyword,
// you have no way to pass parameters to it.

// A singleton object that does not share the same name with a companion class is
// called a standalone object.
object ChecksumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}


object Chapter4 extends App {
  println(ChecksumAccumulator.calculate("Every value is an object."))

}


import ChecksumAccumulator.calculate

// 4.4 Scala application


// To run a Scala program, you must supply the name of a standalone singleton object with
// a main method that takes one parameter, an Array[String], and has a result type of Unit.
// Any standalone object with a main method of the proper signature can be used as the entry
// point into an application.

// Note
// Scala implicitly imports members of packages java.lang and scala, as well as the members of
// a singleton object named Predef, into every Scala source file. Predef,
// which resides in package scala, contains many useful methods. For example,
// when you say println in a Scala source file, you're actually invoking println on Predef. (
// Predef.println turns around and invokes Console.println, which does the real work.)
// When you say assert, you're invoking Predef.assert.
object Summer {
  def main(args: Array[String]) = {
    for (arg <- args)
      println(arg + ": " + calculate(arg))
  }
}

// 4.5 The App trait
// Scala provides a trait, scala.App

// To use the trait, you first write "extends App" after the name of your singleton object.
// Then instead of writing a main method, you place the code you would have put in the main
// method directly between the curly braces of the singleton object.
// You can access command-line arguments via an array of strings named args.
object FallWinterSpringSummer extends App {

  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}

