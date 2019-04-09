package examples_simulacrum

import simulacrum._
import common._

class SimulacrumExample {

  // Type class definition
  @typeclass trait PresentValue[T] {
    def presentValue(t: T): Double
  }

  import PresentValue.ops._ // Helper for syntax is auto-generated

  // Type class instance for Payments
  implicit val PaymentsPV: PresentValue[Payments] = {
    case Annuity(a, i, n) => a * (1 - math.pow(1 + i, -n)) / i
    case Perpetuity(a, i) => a / i
  }

  def testSimulacrumExample(): Unit = {
    val portfolio: Seq[Payments] = Seq(Perpetuity(100.0, 0.02), Annuity(100.0, 0.01, 60))
    assert(totalPV(portfolio) - 9495.5 < 0.01)
  }

  def totalPV[P: PresentValue](ps: Iterable[P]): Double = ps.map(_.presentValue).sum

}
