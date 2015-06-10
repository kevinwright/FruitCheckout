package fruitcheckout


case class ReceiptLine(
  produce: Produce,
  quantity: Int,
  cost: BigDecimal
)
