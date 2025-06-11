// Objects

object Earth {
  // Data
  val radius: Double = 6371.0 // Average Earth radius in km
  val pi: Double = 3.14159
  var population: BigInt = BigInt(8000000000L)

  // Function: Returns surface area and equatorial circumference
  def surfaceArea(): Double = 4 * pi * radius * radius
  def circumference(): Double = 2 * pi * radius
}

val area = Earth.surfaceArea()
val circumference = Earth.circumference()
println(
  s"Earth: Surface Area = $area km², Equatorial Circumference = $circumference km"
)

// create a object with a main function
object MyFirstApplication {
  def main(args: Array[String]): Unit = {
    println("Hello, World!")
  }
}
// instead of an object we can use @main def hello(): Unit =
//@main def hello(): Unit = println("Hello, World!")
