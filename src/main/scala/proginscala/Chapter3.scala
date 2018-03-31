package proginscala

object Chapter3 extends App {
  val greetStrings = new Array[String](3)

  greetStrings(0) = "Hello"
  greetStrings(1) = ", "
  greetStrings(2) = "world!\n"

  //if a method takes only one parameter, you can call it without a dot or parentheses.
  // The to in this example is actually a method that takes one Int argument.
  // The code 0 to 2 is transformed into the method call (0).to(2)
  for (i <- 0 to 2)
    print(greetStrings(i))

  // Creating and initialize an array.
  val numNames = Array("zero", "one", "two")

  val numNames2 = Array.apply("zero", "one", "two")

  // Use lists
  // Scala's List, scala.List, differs from Java's java.util.List type in that Scala Lists
  // are always immutable (whereas Java Lists can be mutable).
  val oneTwo = List(1, 2)
  val threeFour = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour
  println(oneTwo + " and " + threeFour + " were not mutated.")
  println("Thus, " + oneTwoThreeFour + " is a new list.")

  // If a method is used in operator notation, such as a * b, the method is invoked
  // on the left operand, as in a.*(b)—unless the method name ends in a colon.
  // If the method name ends in a colon, the method is invoked on the right operand.
  // Therefore, in 1 :: twoThree, the :: method is invoked on twoThree,
  // passing in 1, like this: twoThree.::(1).
  val twoThree = List(2, 3)
  val oneTwoThree = 1 :: twoThree
  println(oneTwoThree)

  // an empty list is Nil
  val oneTwoThree2 = 1 :: 2 :: 3 :: Nil
  println(oneTwoThree2)

  // Why not append to lists?
  // Class List does offer an "append" operation—it's written :+ and is explained in
  // Chapter 24—but this operation is rarely used, because the time it takes to append to
  // a list grows linearly with the size of the list,
  // whereas prepending with :: takes constant time.
  // If you want to build a list efficiently by appending elements,
  // you can prepend them and when you're done call reverse.
  // Or you can use a ListBuffer, a mutable list that does offer an append operation,
  // and when you're done call toList. ListBuffer will be described in Section 22.2.

  // List methods and usages
  // Empty List
  println(List())
  println(Nil)

  // Concatenates two lists
  println(List("a", "b") ::: List("c", "d"))

  val thrill = "Will" :: "fill" :: "until" :: Nil
  println(thrill)
  println(thrill(2))

  // Counts the number of string elements in thrill that have length 4 (returns 2)
  println(thrill.count(s => s.length == 4))

  // Returns the thrill list without its first 2 elements (returns List("until"))
  println(thrill.drop(2))

  // Returns the thrill list without its rightmost 2 elements (returns List("Will"))
  println(thrill.dropRight(2))

  // Determines whether a string element exists in thrill that has the value "until" (returns true)
  println(thrill.exists(s => s == "until"))

  // Returns a list of all elements, in order, of the thrill list that have length 4
  // (returns List("Will", "fill"))
  println(thrill.filter(s => s.length == 4))

  // Indicates whether all elements in the thrill list end with the letter "l" (returns true)
  println(thrill.forall(s => s.endsWith("l")))


  thrill.foreach(s => print(s))
  thrill.foreach(print)

  println()
  // Returns the first element in the thrill list (returns "Will")
  println(thrill.head)

  // Returns the last element in the thrill list (returns "until")
  println(thrill.last)

  // Returns a list of all but the last element in the thrill list (returns List("Will", "fill"))
  println(thrill.init)

  // Returns the thrill list minus its first element (returns List("fill", "until"))
  println(thrill.tail)

  // Indicates whether the thrill list is empty (returns false)
  println(thrill.isEmpty)

  // Returns the number of elements in the thrill list (returns 3)
  println(thrill.length)

  // Returns a list resulting from adding a "y" to each string element in the thrill list
  // (returns List("Willy", "filly", "untily"))
  println(thrill.map(s => s + "y"))

  // Makes a string with the elements of the list (returns "Will, fill, until")
  println(thrill.mkString(", "))

  // Returns a list of all elements, in order, of the thrill list except
  // those that have length 4 (returns List("until"))
  println(thrill.filterNot(s => s.length == 4))

  // Returns a list containing all elements of the thrill list in reverse order
  // (returns List("until", "fill", "Will"))
  println(thrill.reverse)

  // Returns a list containing all elements of the thrill list in alphabetical order of the f
  // irst character lowercased (returns List("fill", "until", "Will"))
  println(thrill.sortWith((s, t) => s.charAt(0).toLower < t.charAt(0).toLower))


}
