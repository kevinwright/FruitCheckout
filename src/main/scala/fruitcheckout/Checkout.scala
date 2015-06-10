package fruitcheckout

object Checkout extends (List[String] => BigDecimal){
  def calcReceipt(codes: List[String]): List[ReceiptLine] =
    SpecialOffers.applyAll(ParseCodes(codes))

  override def apply(codes: List[String]): BigDecimal =
    calcReceipt(codes).map(_.cost).sum
}
