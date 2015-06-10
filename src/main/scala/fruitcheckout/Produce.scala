package fruitcheckout

case class Produce(
  name: String,
  cost: BigDecimal
)

object Produce {
  val apple  = Produce("Apple",  BigDecimal("0.60"))
  val orange = Produce("Orange", BigDecimal("0.25"))
}
