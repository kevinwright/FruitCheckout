package fruitcheckout

object Checkout extends (List[String] => BigDecimal){
  override def apply(codes: List[String]): BigDecimal = {
    val receipt = ParseCodes(codes)
    receipt.map(_.cost).sum
  }
}
