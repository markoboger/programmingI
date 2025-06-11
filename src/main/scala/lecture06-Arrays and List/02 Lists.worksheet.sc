val numbers: List[Int] = List(1, 2, 3, 4, 5)
val nums = List(1, 2, 3, 4, 5)

val emptyList: List[Int] = List()
val empty = Nil
emptyList == empty

val prependedList = 0 +: nums
val appendedList = nums :+ 6

val prependedList2 = 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: Nil

val robots = List("R2D2", "C3PO", "Optimus", "Bumblebee", "Figure1")
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

//robots(0) = "HAL"
robots(0)

robots.filter(_.length < 5)
