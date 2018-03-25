package tour


// A minimal class
class User

// Primary constructor parameters with val and var
// are public.  val s are immutable.
// Parameters without val or var are private values,
// visible only within the class.
class Point(var x: Int = 0, var y: Int = 0) {

  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
  }

  override def toString: String =
    s"($x, $y)"
}

// Private members and Getter/Setter Syntax
class Point2 {
  private var x = 0
  private var y = 0

  private val bound = 100

  def getX: Int = x

  def setX(newValue: Int): Unit = {
    if (newValue < bound) x = newValue else printWarning
  }

  def getY: Int = y

  def setY(newValue: Int): Unit = {
    if (newValue < bound) y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")

  override def toString: String =
    s"($x, $y)"


}

object Classes extends App {

  // User has a default constructor which takes no arguments.
  val user1 = new User

  val origin = new Point
  println(origin)

  val point1 = new Point(2, 3)
  println(point1)

  // only pass in y.
  val point2 = new Point(y = 2)
  println(point2)

  val point3 = new Point2
  point3.setX(20)
  point3.setY(300)
  println(point3)


}
