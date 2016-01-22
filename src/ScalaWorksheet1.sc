
def getYearEndClosingPrice(symbol : String, year : Int) = {
  val url = s"http://ichart.finance.yahoo.com/table.csv?s=" +
    s"$symbol&a=11&b=01&c=$year&d=11&e=31&f=$year&g=m"

  val data = scala.io.Source.fromURL(url).mkString
  //println(data)
  val price = data.split("\n")(1).split(",")(4).toDouble
  println(price)
  price
}

val symbols = List("GOOG","PINC", "INTC", "AMD", "AAPL", "AMZN", "IBM", "ORCL", "MSFT")
val year = 2015

val (topStock, topPrice) =
  symbols.par.map { ticker => (ticker, getYearEndClosingPrice(ticker, year)) }
    .maxBy { stockPrice => stockPrice._2 }
//val (ts,tp) = symbols.map { ticker => (ticker,getYearEndClosingPrice(ticker,year))}
printf(s"Top stock of $year is $topStock closing at price $$$topPrice")

def findMax(temperatures : List[Int]) = {
  temperatures.foldLeft(Integer.MIN_VALUE) { Math.max }
}

def findMax1(temperatures : List[Int]) = {
  temperatures.foldLeft(Integer.MAX_VALUE) { Math.min }
}
val temp = List(10,20,30,25,40)
println(findMax1(temp))
val values = List(1, 2, 3, 4, 5)
val doubleValues = values.map(_ * 2)
class ScalaInt {
  def playWithInt() {
    val capacity : Int = 10
    val list = new java.util.ArrayList[String]
    list.ensureCapacity(capacity)
  }
}

def getPersonInfo(primaryKey : Int) = {
 // Assume primaryKey is used to fetch a person's info...
  // Here response is hard-coded
  ("Venkat", "Subramaniam", "venkats@agiledeveloper.com")
}

println (getPersonInfo(1)._1)

def max(values: Int*) = values.foldLeft(values(0)) { Math.max }
val numbers = Array(2, 5, 3, 7, 1, 6)

max(numbers: _*)

def mail(destination: String = "head office", mailClass: String = "first") =

  println(s"sending to $destination by $mailClass class")

mail("Houston office", "Priority")

mail("Boston office")

mail()


