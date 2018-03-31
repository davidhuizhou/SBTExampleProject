package proginscala

import scala.collection.mutable
import scala.collection.immutable.HashSet

import scala.io.Source

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


  // Use tuples
  // Like lists, tuples are immutable, but unlike lists, tuples can contain different
  // types of elements. Whereas a list might be a List[Int] or a List[String],
  // a tuple could contain both an integer and a string at the same time.

  // Tuples are very useful, for example, if you need to return multiple objects from a method.
  // you can access its elements individually with a dot, underscore, and the one-based
  // index of the element
  val pair = (99, "Luftballons")

  println(pair._1)
  println(pair._2)
  println(pair)

  // Use sets and maps

  // For example, the Scala API contains a base trait for sets, where a trait is similar
  // to a Java interface.

  // How to create a set
  var jetSet = Set("Boeing", "Airbus")
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))

  // As you can see in Figure 3.2, these three traits all share the same simple name, Set.
  // Their fully qualified names differ, however, because each resides in a different package.
  // scala.collection.Set
  // scala.collection.immutable.Set, scala.collection.mutable.Set
  // scala.collection.immutable.HashSet, scala.collection.mutable.HashSet

  // If you want a mutable set, you'll need to use an import
  // import scala.collection.mutable
  val movieSet = mutable.Set("Hitch", "Poltergeist")
  movieSet += "Shrek"
  println(movieSet)

  // import scala.collection.immutable.HashSet
  val hashSet = HashSet("Tomatoes", "Chilies")
  println(hashSet + "Coriander")

  // Map
  val treasureMap = mutable.Map[Int, String]()
  treasureMap += (1 -> "Go to island.")
  treasureMap += (2 -> "Find big X on ground.")
  treasureMap += (3 -> "Dig.")
  println(treasureMap(2))

  // If you prefer an immutable map, no import is necessary, as immutable is the default map.
  val romanNumeral = Map(
    1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV", 5 -> "V"
  )
  println(romanNumeral(4))

  // How to recoginize the functional style.
  // The first step is to recognize the difference between the two styles in code.
  // One telltale sign is that if code contains any vars, it is probably in an imperative style.
  // If the code contains no vars at all—i.e., it contains only vals—it is probably
  // in a functional style.


  def printArgs1(args: Array[String]): Unit = {
    var i = 0
    while (i < args.length) {
      println(args(i))
      i += 1
    }
  }

  // Translate into functional style by getting rid of the var.
  def printArgs2(args: Array[String]): Unit = {
    for (arg <- args)
      println(arg)
  }

  // or
  def printArgs(args: Array[String]): Unit = {
    args.foreach(println)
  }

  // But you can go even further. The refactored printArgs method is not purely functional because
  // it has side effects—in this case, its side effect is printing to the standard output stream.
  // The telltale sign of a function with side effects is that its result type is Unit.

  // A more functional approach would be to define a method that formats the passed args for
  // printing, but just returns the formatted string.
  def formatArgs(args: Array[String]) = args.mkString("\n")

  val res = formatArgs(Array("zero", "one", "two"))
  assert(res == "zero\none\ntwo")

  // Read lines from a file
  def widthOfLength(s: String) = s.length.toString.length

  if (args.length > 0) {

    val lines = Source.fromFile(args(0)).getLines().toList

    val longestLine = lines.reduceLeft(
      (a, b) => if (a.length > b.length) a else b
    )
    val maxWidth = widthOfLength(longestLine)

    for (line <- lines) {
      val numSpaces = maxWidth - widthOfLength(line)
      val padding = " " * numSpaces
      println(padding + line.length + " | " + line)
    }
  }
  else
    Console.err.println("Please enter filename")


}
