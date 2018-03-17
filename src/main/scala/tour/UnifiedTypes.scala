package tour

object UnifiedTypes extends App {

  // Any is the supertypes of all types
  // AnyVal represents value types (Double, Float, Long, Int, Short, Byte, Char, Unit and Boolean).
  // AnyRef reference types, corresponds to java.lang.Object.
  // Null is a substype of all reference types
  // Nothing is a subtype of all types

  val list: List[Any] = List(
    "a string",
    732,
    'c',
    true,
    () => "an anonymous function returning a string"
  )

  list.foreach(element => println(element))


}
