// create a function that can fail
// we will use integer division with zero as possible parameter

def div0(a: Int, b: Int): Int = a / b

// Example usage:
div0(10, 2)  // returns 5
// div0(10, 0)  // CRASHES with java.lang.ArithmeticException: / by zero

@throws[ArithmeticException]
def div1(a: Int, b: Int): Int = {
  try {
    a / b
  } catch {
    case e: ArithmeticException => throw e
  } finally {
    // cleanup code if needed, executed regardless of success or exception
  }
}

// Example usage:
div1(10, 2)  // returns 5
// div1(10, 0)  // throws java.lang.ArithmeticException: / by zero

import scala.util.{Try, Success, Failure}

def div2(a: Int, b: Int): Try[Int] = {
  if (b == 0) Failure(new ArithmeticException("Division by zero"))
  else Success(a / b)
}

// Example usage:
div2(10, 2)  // Success(5)
div2(10, 0)  // Failure(java.lang.ArithmeticException: Division by zero)


def div3(a: Int, b: Int): Try[Int] = Try(a / b)

// Example usage:
div3(10, 2)  // Success(5)
div3(10, 0)  // Failure(java.lang.ArithmeticException: / by zero)
