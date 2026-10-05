

val list = List(5,2,3,2)

def filterOdds(numbers: List[Int]): List[Int] = {
  numbers match {
    case Nil => Nil
    case head :: tail =>
      if (head % 2 != 0) head :: filterOdds(tail)
      else filterOdds(tail)
  }
}

filterOdds(List(5,2,3,5,3))

def filterEvens(numbers: List[Int]): List[Int] = {
  numbers match {
    case Nil => Nil
    case head :: tail =>
      if (head % 2 == 0) head :: filterEvens(tail)
      else filterEvens(tail)
  }
}

filterEvens(List(5,2,3,5,3))

def filterWith(numbers: List[Int], condition:(Int) => Boolean) :List[Int] = {
    numbers match {
    case Nil => Nil
    case head :: tail =>
      if (condition(head)) head :: filterWith(tail, condition)
      else filterWith(tail, condition)
  }
}

filterWith(List(5,2,3,5,3), _ % 2 == 0)
filterWith(List(5,2,3,5,3), _ % 2 != 0)
filterWith(List(5,2,3,5,3), _ > 3)
filterWith(List(5,2,3,5,3), _ < 5)
filterWith(List(5,2,3,5,3), _ == 2)

List(5,2,3,5,3).filter(_ % 2 == 0)
List(5,2,3,5,3).filter(_ % 2 != 0)
List(5,2,3,5,3).filter(_ > 3)
List(5,2,3,5,3).filter(_ < 5)
List(5,2,3,5,3).filter(_ == 2)

List(5,2,3,5,3).partition(_ % 2 == 0)
List(5,2,3,5,3).partition(_ % 2 != 0)
List(5,2,3,5,3).partition(_ > 3)
List(5,2,3,5,3).partition(_ < 5)
List(5,2,3,5,3).partition(_ == 2)

case class Person(name: String, age: Int)
val people = List(Person("Anakin", 35), Person("Padme", 25), Person("Luke", 12), Person("Lea", 14))
val (minors, majors) = people.partition(_.age < 18)
minors
majors

def sum(numbers: List[Int], f: Int => Int): Int = {
    numbers match {
    case Nil => 0
    case head :: tail => head + sum(tail, f)
  }
}

def product(numbers: List[Int], f: Int => Int): Int = {
    numbers match {
    case Nil => 1
    case head :: tail => head * product(tail, f)
  }
}

def fold(numbers: List[Int], f: (Int, Int) => Int, initial: Int ): Int = {
    numbers match {
    case Nil => initial
    case head :: tail => f(head, fold(tail, f, initial))
  }
}

fold(List(1,2,3,4,5), _ + _, 0)
fold(List(1,2,3,4,5), _ * _, 1)  

List(1,2,3,4,5).reduce(_ + _)
List(1,2,3,4,5).reduce(_ * _)

List(1,2,3,4,5).foldLeft(0)(_ + _)
List(1,2,3,4,5).foldLeft(1)(_ * _)

def map(numbers: List[Int], f: Int => Int): List[Int] = {
    numbers match {
    case Nil => Nil
    case head :: tail => f(head) :: map(tail, f)
  }
}
    
map(List(1,2,3,4,5), _ * 2)

List(1,2,3,4,5).map(_ * 2)
