package examples_basic

import java.time.LocalDate

// Define a type class instance for an existing type class
class Example2 {

  // Type class instance
  // If you comment it out, you'll get a compiler error
  implicit val localDateOrdering: Ordering[LocalDate] = (x, y) => x.compareTo(y)

  def testExample2(): Unit = {
    val date1 = LocalDate.of(2018, 6, 1)
    val date2 = LocalDate.of(2018, 4, 1)
    val date3 = LocalDate.of(2018, 5, 1)

    val dates = Seq(date1, date2, date3)
    val datesSorted = dates.sorted

    assert(datesSorted == Seq(date2, date3, date1))
  }

}
