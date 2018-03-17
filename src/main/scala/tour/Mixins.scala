package tour

// Mixins are traits which are used to compose a class.
abstract class A {
  val message: String
}

class B extends A {
  val message = "I'm an instance of class B"
}

trait C extends A {
  def loudMessage = message.toUpperCase()
}


// Class D has a superclass B and a mixin C.  Classes can only have one
// superclass but many mixins.
class D extends B with C

abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next(): T
}

// This trait implements foreach by continually calling the provided function
// f:T => Unit on the next element(next()).
// Because it is a trait, it doesn't need to implement the abstract members of AbsIterator.
trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next())
}


class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  def hasNext = i < s.length()

  def next(): T = {
    val ch = s charAt i
    i += 1
    ch
  }

}

object Mixins extends App {
  val d = new D
  println(d.message)
  println(d.loudMessage)

  // RichStringIter has StringIterator as superclass
  // and RichIterator as a mixin
  class RichStringIter extends StringIterator("Scala") with RichIterator

  var richStringIter = new RichStringIter
  richStringIter foreach println


}
