package examples_basic

// Create a generic function using a type class and its instances
class Example1 {

  // Two different syntactic variants

  def sq[N: Numeric](n: N): N = implicitly[Numeric[N]].times(n, n)

  def sq2[N](n: N)(implicit numeric: Numeric[N]): N = numeric.times(n, n)

  def testExample1(): Unit = {
    val x1: Byte = 2
    val x2: Short = 2
    val x3: Int = 2
    val x4: Long = 2
    val x5: Float = 2
    val x6: Double = 2

    assert(sq(x1) == 4)
    assert(sq(x2) == 4)
    assert(sq(x3) == 4)
    assert(sq(x4) == 4)
    assert(sq(x5) == 4)
    assert(sq(x6) == 4)

    assert(sq2(x1) == 4)
    assert(sq2(x2) == 4)
    assert(sq2(x3) == 4)
    assert(sq2(x4) == 4)
    assert(sq2(x5) == 4)
    assert(sq2(x6) == 4)
  }

}
