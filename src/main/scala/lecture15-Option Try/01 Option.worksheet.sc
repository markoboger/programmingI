// Dictionary lookup example to explain Option
// Real-world analogy: Looking up a word in a dictionary - sometimes it exists, sometimes it doesn't

// Grade as a nullable type alias
type Grade = Int | Null

// Create a student grades database with nullable grades
val grades: Map[String, Grade] = Map(
  "alice123" -> 85,
  "bob456" -> null,  // Bob has no grade yet
  "charlie789" -> 78,
  "diana999" -> 95
)

// BAD APPROACH: Direct lookup that can crash or return null
def getGradeBad(studentId: String): Grade = grades(studentId)

// Example usage:
getGradeBad("alice123")  // returns 85
getGradeBad("bob456")    // returns null - dangerous!
// getGradeBad("unknown")  // CRASHES with java.util.NoSuchElementException - COMMENTED OUT TO PREVENT ERROR

// Problems with null grades:
// If you forget to check for null, you get runtime crashes
def calculatePercentage(studentId: String): String = {
  val grade = getGradeBad(studentId)
  s"$grade%"  // This will print "null%" for bob, which is confusing
}

calculatePercentage("alice123")  // "85%"
calculatePercentage("bob456")    // "null%" - not helpful!

// BETTER APPROACH: Using Option
// Convert nullable Grade to Option to handle null safely
def getGrade(studentId: String): Option[Int] = grades.get(studentId) match
  case Some(null) => None  // Convert null to None
  case Some(grade: Int) => Some(grade)  // Only non-null grades
  case None => None

// Example usage:
getGrade("alice123")    // Some(85)
getGrade("bob456")      // None (was null, now safely converted)
getGrade("unknown")     // None

// Working with Option values

// 1. Using getOrElse - provide a default value
val aliceGrade = getGrade("alice123").getOrElse(0)     // 85
val unknownGrade = getGrade("unknown").getOrElse(0)    // 0 (default)

// 2. Using map - transform the value if it exists
val aliceGradePercent = getGrade("alice123").map(g => s"$g%")    // Some("85%")
val unknownGradePercent = getGrade("unknown").map(g => s"$g%")   // None

// 3. Using filter - keep only values that match a condition
val passingGrade = getGrade("alice123").filter(_ >= 60)     // Some(85) - passing
val failingCheck = getGrade("alice123").filter(_ < 60)      // None - not failing

// 4. Using flatMap - chain operations that return Option
def getLetterGrade(score: Int): Option[String] = 
  if (score >= 90) Some("A")
  else if (score >= 80) Some("B") 
  else if (score >= 70) Some("C")
  else if (score >= 60) Some("D")
  else Some("F")

val aliceLetterGrade = getGrade("alice123").flatMap(getLetterGrade)  // Some("B")
val unknownLetterGrade = getGrade("unknown").flatMap(getLetterGrade) // None

// 5. Pattern matching with Option
def gradeReport(studentId: String): String = getGrade(studentId) match
  case Some(grade) => s"Student $studentId has grade: $grade"
  case None => s"Student $studentId not found"

gradeReport("alice123")  // "Student alice123 has grade: 85"
gradeReport("unknown")   // "Student unknown not found"

// 6. Checking if Option has a value
getGrade("alice123").isDefined   // true
getGrade("alice123").nonEmpty    // true
getGrade("unknown").isEmpty      // true

// 7. Converting Option to other types
getGrade("alice123").toList      // List(85)
getGrade("unknown").toList       // List() - empty list

// Real-world example: Processing multiple students
val studentIds = List("alice123", "unknown", "bob456", "missing")

// Get all existing grades (filter out None values)
val existingGrades = studentIds.flatMap(getGrade)  // List(85, 92)

// Get grades with defaults for missing students
val gradesWithDefaults = studentIds.map(id => getGrade(id).getOrElse(0))  // List(85, 0, 92, 0)

// Count how many students we found
val foundStudents = studentIds.count(id => getGrade(id).isDefined)  // 2

