package tour

// Coercing methods into functions
// It is also possible to pass methods as arguments to higher-order functions
// because the Sala compiler will corece the method into a function.
case class WeelyWeatherForce(temperatures: Seq[Double]) {
  private def convertCtoF(temp: Double) = temp * 1.8 + 32

  //  Here the method convertCtoF is passed to forecastInFahrenheit.
  // This is possible because the compiler coerces convertCtoF to the function x => convertCtoF(x)
  // (note: x will be a generated name which is guaranteed to be unique within its scope).
  def forecastInFaherenheit: Seq[Double] = temperatures.map(convertCtoF)
}

/**
  * Without creating a higher-order function.
  */
object SalaryRaiser {

  def smallPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * salary)
}

/**
  * Notice how each of the three methods vary only by the multiplication factor. To simplify,
  * you can extract the repeated code into a higher-order function like so:
  */
object SalaryRaiserWithHighOrderFunction {

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)
}

/**
  * Higer order functions take other functions as parameters or return a function as a result.
  */
object HigherOrderFunctions extends App {

  // One of the most common examples is the higher-order function map which
  // is avaiable for collections in Scala.
  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary)
  println(newSalaries)

  // To shrink the code, make the function anonymous and pass it directly as
  // an argument to map.
  val newSalaries2 = salaries.map(x => x * 2)
  println(newSalaries2)

  val newSalaries3 = salaries.map(_ * 2)
  println(newSalaries3)

  val weelyWeatherForce = new WeelyWeatherForce(Seq(-40, 0, 37, 100))
  println(weelyWeatherForce.forecastInFaherenheit)

  val salaries1 = List(100.0, 200.0, 300.0)
  println(SalaryRaiser.smallPromotion(salaries1))

  // Functions that return functions
  // There are certain cases where you want to generate a function.
  // Here’s an example of a method that returns a function.
  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  val domainName = "www.example.com"

  def getURL = urlBuilder(ssl = true, domainName)

  val endpoint = "users"
  val query = "id=1"
  val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
  println(url)


}
