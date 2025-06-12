// Classes

{
// Person and Planet

  class Person(name: String, age: Int)
  class Planet(name: String, radius: Double)

  val luke = new Person("Luke", 42)
  val earth = new Planet("Earth", 6371.0)

  val lea = Person("Lea", 25)
  val mars = new Planet("Mars", 3390.0)

}

{
// create a class Planet with data radius and functions surfaceArea and circumference
  class Planet(name: String, radius: Double) {
    val pi: Double = 3.14159
    def surfaceArea(): Double = 4 * pi * radius * radius
    def circumference(): Double = 2 * pi * radius
  }

  val earth = new Planet("Earth", 6371.0)
  earth.surfaceArea()
  earth.circumference()

// create a few Persons with parameters in order and named parameter
  class Person(name: String, age: Int)
  val luke = new Person("Luke", 42)
  val lea = new Person(name = "Lea", age = 25)
  val anakin = new Person(age = 69, name = "Anakin")
}

{
  // create a class Planet with data radius and an optional parameter density with a default value of 5.514 g/cm^3 and functions surfaceArea and circumference
  class Planet(name: String, radius: Double, density: Double = 5.514) {
    val pi: Double = 3.14159
    def surfaceArea(): Double = 4 * pi * radius * radius
    def circumference(): Double = 2 * pi * radius
    def mass(): Double = density * radius * radius * radius
  }

  val earth = new Planet("Earth", 6371.0)
  val jupiter = new Planet("Jupiter", radius = 71492.0, density = 1.326)
  earth.surfaceArea()
}

{
  // create a class Planet with data radius and an optional parameter density with a default value of 5.514 g/cm^3 and functions surfaceArea and circumference
  class Planet(name: String, radius: Double, density: Double = 5.514) {
    val pi: Double = 3.14159
    val surfaceArea: Double = 4 * pi * radius * radius
    val circumference: Double = 2 * pi * radius
    val mass: Double = density * radius * radius * radius
  }

  val earth = new Planet("Earth", 6371.0)
  val jupiter = new Planet("Jupiter", radius = 71492.0, density = 1.326)
  earth.surfaceArea
}

{
  // lazy evaluation
  class Planet(name: String, radius: Double, density: Double = 5.514) {
    val pi: Double = 3.14159
    lazy val surfaceArea: Double = 4 * pi * radius * radius
    lazy val circumference: Double = 2 * pi * radius
    lazy val mass: Double = density * radius * radius * radius
  }

  val earth = new Planet("Earth", 6371.0)
  val jupiter = new Planet("Jupiter", radius = 71492.0, density = 1.326)

  earth.surfaceArea

}

{
// create a class Planet with data radius and an optional parameter density with a default value of 5.514 g/cm^3 and functions surfaceArea and circumference
  class Planet(val name: String, val radius: Double, density: Double = 5.514) {
    private val pi: Double = 3.14159
    def surfaceArea(): Double = 4 * pi * radius * radius
    def circumference(): Double = 2 * pi * radius
    private def mass(): Double = density * radius * radius * radius
  }

  val earth = new Planet("Earth", 6371.0)
  println(earth.name)
  println(earth.radius)
  //println(earth.density) // does not compile
  println(earth.surfaceArea())
  println(earth.circumference())
  //println(earth.mass) // does not compile

}

// initialize during construction
class Planet(val name: String, val radius: Double, density: Double = 5.514) {
  val pi: Double = 3.14159
  var mass = 0.0

  def surfaceArea(): Double = 4 * pi * radius * radius
  def init(): Unit = {
    mass = density * radius * radius * radius
  }
  init()

}

val earth = new Planet("Earth", 6371.0)
println(earth.name)
println(earth.radius)
println(earth.surfaceArea())
println(earth.mass)
