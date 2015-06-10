package fruitcheckout

object ParseCodes extends (List[String] => List[ReceiptLine]) {
  override def apply(codes: List[String]): List[ReceiptLine] = {
    val products = for {
      code <- codes
      p <- SingleCodeLookup(code)
    } yield p
    val histogram = products.groupBy(identity).mapValues(_.length)
    histogram.map{ ReceiptLine.tupled }(collection.breakOut)
  }
}
