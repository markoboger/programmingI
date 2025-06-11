val x: Int = 42
var name: String = "Luke"

def f1(x: Int): Int => Int = x => x + 1
def f2(x: Int): Int = x + 2
def f3(x: Int) = x + 3

f1(1)
f2(1)
f3(1)

def isEven(x: Int): Int => Boolean = x => x % 2 == 0
def isOdd(x: Int): Boolean = x % 2 != 0

isEven
isEven(1)
isEven(2)

isOdd
isOdd(1)
isOdd(2)

def sum(xs: List[Int]): Int = {
  if (xs.isEmpty) 0
  else xs.head + sum(xs.tail)
}

sum
sum(List(1, 2, 3, 4, 5))

def sum2 = sum
sum2

sum2(List(1, 2, 3, 4, 5))

// show a simple tuple definitions
val tuple = (42, "Luke", true)
tuple._1
tuple._2
tuple._3

// create a function for integer division that returns a tuple of the quotient and the remainder
def div(x: Int, y: Int): (Int, Int) = (x / y, x % y)

val divResult = div(10, 3)
divResult._1
divResult._2

// assignment to a tuple
val (quotient, remainder) = div(10, 3)
quotient
remainder
