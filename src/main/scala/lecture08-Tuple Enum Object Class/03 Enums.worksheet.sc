// Enum

enum Weekday {
  case Monday, Tuesday, Wednesday, Thursday, Friday,
    Saturday, Sunday
}

enum CardType {
  case Heart, Diamond
  case Club, Spade
}

// Enums for the planets of the solar system with a function to return the mass from the radius
enum Planet(radius: Double) {
  // Data
  case Earth extends Planet(6371.0)
  case Mars extends Planet(3390.0)
  case Jupiter extends Planet(71492.0)
  case Saturn extends Planet(60268.0)
  case Uranus extends Planet(25559.0)
  case Neptune extends Planet(24764.0)

  // Accessor method for radius
  def getRadius: Double = radius

  val density: Double = 5.514 // average density of the planet in g/cm^3
  val pi: Double = 3.14159

  // Functions
  def mass: Double = density * radius * radius * radius
  def surfaceArea: Double = 4 * pi * radius * radius
  def circumference: Double = 2 * pi * radius
}

val earth = Planet.Earth
earth.mass
earth.surfaceArea
earth.circumference

import Planet._

val earth2 = Earth

enum ConsoleColors(val code: String) {
  case CLEAR extends ConsoleColors("\u001B[0m")
  case RED extends ConsoleColors("\u001B[31m")
  case GREEN extends ConsoleColors("\u001B[32m")
  case YELLOW extends ConsoleColors("\u001B[33m")
  case BLUE extends ConsoleColors("\u001B[34m")
  case PURPLE extends ConsoleColors("\u001B[35m")
  case CYAN extends ConsoleColors("\u001B[36m")
  case WHITE extends ConsoleColors("\u001B[37m")

  def apply(text: String): String = s"$code$text${CLEAR.code}"
}

ConsoleColors.RED("Error!")

import ConsoleColors._

RED("Error!")
YELLOW("Warning!")
GREEN("Success!")

println(RED("Error!"))
