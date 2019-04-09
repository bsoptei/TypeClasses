package object common {

  sealed trait Payments

  final case class Perpetuity(amount: Double, interestRate: Double) extends Payments

  final case class Annuity(amount: Double, interestRate: Double, periods: Int) extends Payments

}
