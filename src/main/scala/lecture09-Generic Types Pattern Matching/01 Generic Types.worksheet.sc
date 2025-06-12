// List of Integers
val list1 : List[Int] = List(1, 2, 3, 4, 5)

// List of Strings
val list2 : List[String] = List("a", "b", "c", "d", "e")

// List of Tuple
val list3 : List[(Int, String)] = List((1, "a"), (2, "b"), (3, "c"), (4, "d"), (5, "e"))

// List of Enums
enum Weekday {
  case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
}
import Weekday._
val list4 : List[Weekday] = List(Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday)

// List of Objects
class Person(name: String, age: Int)
val list5 : List[Person] = List(Person("Anakin", 30), Person("Padme", 25))

// List of List
val list6 : List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))

// create a type using a generic type T and a type parameter A
class Box[T](value: T)
val box1 : Box[Int] = Box(1)
val box2 : Box[String] = Box("Hello")
val box3 : Box[Person] = Box(Person("Anakin", 30))

// Operations on List[]
val list = List(5,2,3,2)
list.head
list.tail
list.length
list.reverse
list.sorted
list.distinct
list.toString
list.mkString("|", " - ", "|")
list.sum
list.product
list.max
list.min
list.contains(2)
list.zipWithIndex
list.zip(list2)

// Operations on Iterable 
list.take(2)
list.drop(2)
list.takeRight(2)
list.dropRight(2)
list.slice(1, 3)
list.patch(1, List(6, 7), 2)

// Operations on Iterator
val iterator1 = list.sliding(2)
iterator1.next
iterator1.next
val iterator2 = list.grouped(2)    
iterator2.next
iterator2.next

// operations with higher order functions
list.foreach(println)
list.map(_ * 2)
list.filter(_ > 3)
list.exists(_ > 3)
list.forall(_ > 3)
list.partition(_ > 3)
list.foldLeft(0)(_ + _)
list.foldRight(0)(_ + _)
list.reduceLeft(_ + _)
list.reduceRight(_ + _)
list.scanLeft(0)(_ + _)
list.scanRight(0)(_ + _)

// compare for and foreach
for (elem <- list) println(elem)
list.foreach(println)
list.foreach(elem  => println(elem))
list.foreach(elem => println(elem))

val list7 = list.map(elem => elem * 2)
list7
val list8 = list.map(_ * 2)
list8

list.map(elem => println(elem))

val list9 = for (elem <- list) yield elem * 2
list9

// example for a while loop
var i = 0
while (i < list.length) {
  println(list(i))
  i += 1
}
