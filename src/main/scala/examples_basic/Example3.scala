package examples_basic

import common._

// Define a custom type class and instances
class Example3 {

  // Type class definition
  trait PresentValue[T] {
    def presentValue(t: T): Double
  }

  // Type class instance for Annuity
  implicit val AnnuityPV: PresentValue[Annuity] =
    a => a.amount * (1 - math.pow(1 + a.interestRate, -a.periods)) / a.interestRate

  // Type class instance for Perpetuity
  implicit val PerpetuityPV: PresentValue[Perpetuity] = p => p.amount / p.interestRate

  // Helper for syntax
  implicit class PVOps[P: PresentValue](p: P) {
    def presentValue: Double = implicitly[PresentValue[P]].presentValue(p)
  }

  def testExample3(): Unit = {
    assert(Perpetuity(100.0, 0.02).presentValue == 5000.0)
    assert(Annuity(100.0, 0.01, 60).presentValue - 4495.5 < 0.01)
  }

}
