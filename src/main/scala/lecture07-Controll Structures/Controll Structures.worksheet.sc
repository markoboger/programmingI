// Assignment

// var

var x = 42
x = 21

var anakin: String = "Anakin Skywalker"
anakin = "Darth Vader"

var theForceIsStrong = true

x==21
x==42

anakin=="Anakin Skywalker"
anakin=="Darth Vader"

theForceIsStrong==true
theForceIsStrong==false

{
var padme: String = "Padme Amidala"

var age: Int = 26
}

var padme = "Padme Amidala"
var age = 26

// val
val pi = 3.14159

val luke = "Luke Skywalker"

// Scope
{
    val anakin = "Anakin Skywalker"
}
{
    val anakin = "Darth Vader"
}

// Shadowing
{
    val anakin = "Anakin Skywalker"
    {
        val anakin = "Darth Vader"
        println (anakin)
    }
    println (anakin)
}

// Statements
val meaningOfLife = 42; println(meaningOfLife)

// Expressions

import math._
17+4
sin(x) * log(1 + x * x) + exp(x / pi)
theForceIsStrong==true

// Combining statements and expressions
val blackjack = 17+4
println(sin(x) * log(1 + x * x) + exp(x / pi))

// Control structures
val boolean_expression = true
val statement = println("Hello, World!")
val expression = 17+4
if (boolean_expression) { statement }
if (boolean_expression) then { statement }
if (boolean_expression) then statement
if boolean_expression then statement

if boolean_expression then statement else statement
if boolean_expression 
then statement 
else statement



if (boolean_expression) { expression }
if (boolean_expression) then { expression }
if (boolean_expression) then expression
if boolean_expression then expression

if (boolean_expression) { expression } else { expression }
if (boolean_expression) then { expression } else { expression }
if (boolean_expression) then expression else expression
if boolean_expression then expression else expression



val result = if (boolean_expression) then expression else expression
(if boolean_expression then expression else expression) + (if boolean_expression then expression else expression)

// if as statement
val points = 22
if (points  > 21) println("Busted!")
else if (points == 21) println("Blackjack!")
else println("Points: " + points)

// if as expression
val result2 = if (points  > 21) "Busted!" 
    else if (points == 21) "Blackjack!" 
    else "Points: " + points
println(result2)

// if as statement with age
if (age >= 18) println("Adult")
else println("Minor")

// if as expression with age
val age2 = 26
val ageGroup = if (age2 >= 18) "Adult" else "Minor"
println(ageGroup)

// if without parentheses as statement  
if age >= 18 then println("Adult") else println("Minor")

// if without parentheses as expression
val ageGroup2 = if age >= 18 then "Adult" else "Minor"
println(ageGroup2)


// for loop with Range
for (i <- 0 until 10) println(i)
for (i <- 0 to 10) println(i)

// for (generator) statement
// for (generator) yield expression
// for (generator) statement yield expression

// for loop over an index of an Array
val array = Array(1, 2, 3, 4, 5)
for (i <- 0 until array.length) println(array(i))

// for loop over an index of an Array with a step
for (i <- 0 until array.length by 2) println(array(i))

// for loop over an index of an Array with a condition
for (i <- 0 until array.length if array(i) % 2 == 0) println(array(i))

// for loop over an index of an Array with a step and a condition
for (i <- 0 until array.length by 3 if array(i) % 2 == 0) println(array(i))

// for loop as an expression, using yield
var vector: IndexedSeq[Int] = Vector()
vector = for (i <- 0 until array.length) yield i
vector
// for loop as an expression, using yield with a step
vector = for (i <- 0 until array.length by 2) yield i
vector
// for loop as an expression, using yield with a condition
vector = for (i <- 0 until array.length if array(i) % 2 == 0) yield i
vector
// for loop as an expression, using yield with a step and a condition
vector = for (i <- 0 until array.length by 3 if array(i) % 2 == 0) yield i
vector

// for over a List
val list: List[Int] = List(1, 2, 3, 4, 5)
val result3 : List[Int] = for (elem <- list) yield elem
result3
// for over a List with a condition
val result4 : List[Int] = for (elem <- list if elem % 2 == 0) yield elem
result4
{
// for over an array
val array = Array(1, 2, 3, 4, 5)
val result5 : Array[Int] = for (elem <- array) yield elem
result5
}


// speed comparison of a for loop over an array and a for loop over a list
val startTime = System.currentTimeMillis()
val largeArray = Array.fill(1_000_000)(util.Random.nextInt())
val result6 = for (elem <- largeArray) yield elem
val endTime = System.currentTimeMillis()
println(s"Time taken: ${endTime - startTime} ms")

val startTime2 = System.currentTimeMillis()
val largeList = List.fill(1_000_000)(util.Random.nextInt())
val result7 = for (elem <- largeList) yield elem
val endTime2 = System.currentTimeMillis()
println(s"Time taken: ${endTime2 - startTime2} ms")
