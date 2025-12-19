// Simple implementation of Option using Scala 3 enums
enum MyOption[+T]:
  case MySome(value: T)
  case MyNone

  // map operation - transform the value if it exists
  def map[U](f: T => U): MyOption[U] = this match
    case MySome(value) => MySome(f(value))
    case MyNone => MyNone

  // flatMap operation - chain operations that return MyOption
  def flatMap[U](f: T => MyOption[U]): MyOption[U] = this match
    case MySome(value) => f(value)
    case MyNone => MyNone

  // filter operation - keep only values that match a condition
  def filter(predicate: T => Boolean): MyOption[T] = this match
    case MySome(value) if predicate(value) => MySome(value)
    case _ => MyNone

  // get the value or throw an exception
  def get: T = this match
    case MySome(value) => value
    case MyNone => throw new NoSuchElementException("MyNone.get")

  // get the value or return a default
  def getOrElse[U >: T](default: => U): U = this match
    case MySome(value) => value
    case MyNone => default

  // check if value exists
  def isDefined: Boolean = this match
    case MySome(_) => true
    case MyNone => false

  // check if no value exists
  def isEmpty: Boolean = !isDefined

  // alias for isDefined
  def nonEmpty: Boolean = isDefined

// Companion object with utility methods
object MyOption:
  def apply[T](value: T): MyOption[T] = 
    if (value == null) MyNone else MySome(value)

  def empty[T]: MyOption[T] = MyNone

// Example usage of MyOption
def safeDivide(a: Int, b: Int): MyOption[Int] = 
  if (b != 0) MyOption.MySome(a / b) else MyOption.MyNone

// Test cases
val result1 = safeDivide(10, 2)  // MySome(5)
val result2 = safeDivide(10, 0)  // MyNone

// Using map
val doubled = result1.map(_ * 2)  // MySome(10)
val doubledNone = result2.map(_ * 2)  // MyNone

// Using flatMap
val chained = result1.flatMap(x => MyOption.MySome(x + 5))  // MySome(10)
val chainedNone = result2.flatMap(x => MyOption.MySome(x + 5))  // MyNone

// Using filter
val evenOnly = result1.filter(_ % 2 == 0)  // MyNone (5 is odd)
val oddOnly = result1.filter(_ % 2 != 0)   // MySome(5) (5 is odd)

// Using getOrElse
val safeValue1 = result1.getOrElse(0)  // 5
val safeValue2 = result2.getOrElse(0)  // 0

// Check status
result1.isDefined  // true
result1.nonEmpty   // true
result2.isEmpty    // true

// Pattern matching with MyOption
def describe(opt: MyOption[Int]): String = opt match
  case MyOption.MySome(value) => s"Found value: $value"
  case MyOption.MyNone => "No value found"

describe(result1)  // "Found value: 5"
describe(result2)  // "No value found"

// Chaining operations
val complexOperation = safeDivide(20, 4)
  .map(_ * 3)           // MySome(15)
  .filter(_ > 10)       // MySome(15) - passes filter
  .map(_ + 1)           // MySome(16)
  .getOrElse(0)         // 16

// Working with nullable values
val nullableString: String | Null = "hello"
val nullValue: String | Null = null

val option1 = MyOption(nullableString)  // MySome("hello")
val option2 = MyOption(nullValue)       // MyNone

// Converting between MyOption and List-like operations
def toList[T](opt: MyOption[T]): List[T] = opt match
  case MyOption.MySome(value) => List(value)
  case MyOption.MyNone => List.empty

toList(result1)  // List(5)
toList(result2)  // List()

// Real-world example: Safe dictionary lookup
val grades: Map[String, Int] = Map(
  "alice" -> 85,
  "bob" -> 92,
  "charlie" -> 78
)

def getGrade(studentId: String): MyOption[Int] = 
  grades.get(studentId) match
    case Some(grade) => MyOption.MySome(grade)
    case None => MyOption.MyNone

val aliceGrade = getGrade("alice")    // MySome(85)
val unknownGrade = getGrade("diana")  // MyNone

// Processing grades safely
val letterGrade = aliceGrade
  .filter(_ >= 60)                    // MySome(85) - passing grade
  .map(score => if (score >= 90) "A" 
               else if (score >= 80) "B"
               else if (score >= 70) "C"
               else "D")               // MySome("B")
  .getOrElse("F")                     // "B"
