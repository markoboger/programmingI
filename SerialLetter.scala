// Programming I — Lecture 04
// Example: form letters with exam results
// Allowed: String, Int, Boolean, List, var, val, def, main
// No file access — output only with println

object SerialLetter:

  def letterText(name: String, matriculationNumber: Int, grade: Double): String =
    val passed = grade <= 4.0
    val result =
      if passed then "passed"
      else "failed"

    s"""Subject: Result of the Programming I exam
      |
      |Dear $name,
      |
      |regarding your matriculation number $matriculationNumber we would like to inform you:
      |
      |  Grade: ${f"$grade%.1f"} ($result)
      |
      |Best regards
      |Your Examination Office
      |----------------------------------------""".stripMargin

  def writeLetter(name: String, matriculationNumber: Int, grade: Double): Unit =
    println(letterText(name, matriculationNumber, grade))

  def main(args: Array[String]): Unit =
    val names =
      List("Anna Müller", "Ben Schmidt", "Clara Weber", "David Braun")
    val matriculationNumbers =
      List(512341, 512342, 512343, 512344)
    val grades =
      List(1.0, 3.3, 5.0, 2.7)

    writeLetter(names(0), matriculationNumbers(0), grades(0))
    writeLetter(names(1), matriculationNumbers(1), grades(1))
    writeLetter(names(2), matriculationNumbers(2), grades(2))
    writeLetter(names(3), matriculationNumbers(3), grades(3))
