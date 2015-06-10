package fruitcheckout


case class ReceiptLine(
  produce: Produce,
  quantity: Int
) {
  def cost = quantity * produce.cost
}
