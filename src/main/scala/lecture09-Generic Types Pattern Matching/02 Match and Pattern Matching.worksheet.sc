// Example of match
// match as statement
val character = "Luke"
character match {
  case "Luke" => println("The power of the Force is strong with you.")  
  case "Anakin" => println("I am your father.")
  case "Padme" => println("I am your mother.")
  case _ => println("Do or do not. There is no try.")
}

val characterList = List("Luke", "Anakin", "Padme")
for (character <- characterList) character match {
  case "Luke" => println("The power of the Force is strong with you.")  
  case "Anakin" => println("I am your father.")
  case "Padme" => println("I am your mother.")
  case _ => println("Do or do not. There is no try.")
}

// match as expression
for (character <- characterList) {
  val theForceIsStrong = character match {
    case "Luke" => true  
    case "Anakin" => true
    case "Padme" => false
    case _ => false
  }
}    

enum Status {
  case Jedi, SithLord, Senator
}
import Status._
val status = Jedi
val theForceIsStrong = status match {
  case Jedi => true
  case SithLord => true
  case Senator => false
  case _ => false
}
  
// match on type
val x: Any = 42
x match {
  case i: Int => println("Integer: " + i)
  case s: String => println("String: " + s)
  case _ => println("Unknown type")
}

// match on value
val y: Int = 42
y match {
  case 42 => println("The answer to life, the universe, and everything")
  case _ => println("Unknown value")
}

val list10 = List(13, 21, 42, 63)
val shoutout =  for (x <- list10) yield x match {
  case 21 => "Blackjack!"
  case 42 => "The answer to life, the universe, and everything"
  case _ => "Unknown value"
}
shoutout


// match with guards
val number: Int = 42
number match {
  case positiveNumber if positiveNumber > 0 => println("Positive")
  case negativeNumber if negativeNumber < 0 => println("Negative")
  case zero if zero == 0 => println("Zero")
}


// Roman Character to Number
def romanCharToNumber(romanChar: Char): Int = {
  romanChar match {
    case 'I' => 1
    case 'V' => 5
    case 'X' => 10
    case 'L' => 50
    case 'C' => 100
    case 'D' => 500
    case 'M' => 1000
    case _ => 0
  } 
}
romanCharToNumber('X')

  
def div(x: Int, y: Int): (Int, Int) = (x / y, x % y)
val (quotient, remainder) = div(10, 3)

List(1, 2, 3) match {
  case head :: tail => println("Head: " + head + " Tail: " + tail)
  case Nil => println("Empty list")
}


// Roman Number to Number
def romanToNumber(roman: List[Char]): Int = {
    roman match {
      case 'I' :: 'V' :: tail => 4 + romanToNumber(tail)
      case 'I' :: 'X' :: tail => 9 + romanToNumber(tail)
      case 'X' :: 'L' :: tail => 40 + romanToNumber(tail)
      case 'X' :: 'C' :: tail => 90 + romanToNumber(tail)
      case 'C' :: 'D' :: tail => 400 + romanToNumber(tail)
      case 'C' :: 'M' :: tail => 900 + romanToNumber(tail)
      case 'I' :: tail => 1 + romanToNumber(tail)
      case 'V' :: tail => 5 + romanToNumber(tail)
      case 'X' :: tail => 10 + romanToNumber(tail)
      case 'L' :: tail => 50 + romanToNumber(tail)
      case 'C' :: tail => 100 + romanToNumber(tail)
      case 'D' :: tail => 500 + romanToNumber(tail)
      case 'M' :: tail => 1000 + romanToNumber(tail)
      case Nil => 0
      case _ => 0
    }
}
romanToNumber("XVI".toList)
romanToNumber("MCMXCIV".toList)      


// pattern matching with case classes
case class Person(first: String, last: String)
val person = Person("Anakin", "Skywalker")
person match {
  case Person(first, last) => println("Name: " + first + " " + last)
}

val jedis = List(Person("Anakin", "Skywalker"), Person("Luke", "Skywalker"))
for (jedi <- jedis) jedi match {
  case Person(_, "Skywalker") => println("The Force is strong with you.")
  case _ => println("Do or do not. There is no try.")
}
