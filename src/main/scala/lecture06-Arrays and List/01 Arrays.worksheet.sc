val robots = new Array[String](5)
robots(0) = "R2D2"
robots(1) = "C3PO"
robots(2) = "Optimus"
robots(3) = "Bumblebee"
robots(4) = "Figure1"

robots
robots.length
robots(0)
robots(1)
robots(2)
robots(3)
robots(4)

for (i <- 0 until robots.length) {
  println(robots(i))
}

for (robot <- robots) {
  println(robot)
}

robots(0) = "HAL"
robots(0)

//create and array with 10.000.000 random numbers and iterate over it. Stop the time it takes to iterate over it.
val randomNumbers = new Array[Int](10_000_000)
for (i <- 0 until randomNumbers.length) {
  randomNumbers(i) = util.Random.nextInt()
}

val startTime = System.currentTimeMillis()
for (i <- 0 until randomNumbers.length) {
  randomNumbers(i)
}
val endTime = System.currentTimeMillis()
println(s"Time taken: ${endTime - startTime} ms")

// create a List with 10.000.000 random numbers and iterate over it. Stop the time it takes to iterate over it.
val randomNumbersList = List[Int]()
for (number <- 0 until 10_000_000) {
  util.Random.nextInt() :: randomNumbersList
}

val startTimeList = System.currentTimeMillis()
for (item <- randomNumbersList) {
  item
}
val endTimeList = System.currentTimeMillis()
println(s"Time taken: ${endTimeList - startTimeList} ms")
