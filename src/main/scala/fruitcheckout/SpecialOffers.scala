package fruitcheckout


object SpecialOffers {

  val freeApple = Produce("Buy one Apple, get one free", -Produce.apple.cost)
  val freeOrange = Produce("Three oranges for the price of two", -Produce.orange.cost)

  val bogoffApples = (receipt: List[ReceiptLine]) =>  {
    val offerLine = for {
      line <- receipt.find(_.produce == Produce.apple)
      freeQty = line.quantity / 2
      if freeQty > 0
    } yield ReceiptLine(freeApple, freeQty)

    receipt ++ offerLine.iterator
  }

  val multisaveOranges = (receipt: List[ReceiptLine]) => {
    val offerLine = for {
      line <- receipt.find(_.produce == Produce.orange)
      freeQty = line.quantity / 3
      if freeQty > 0
    } yield ReceiptLine(freeOrange, freeQty)

    receipt ++ offerLine.iterator
  }

  val applyAll = bogoffApples andThen multisaveOranges
}
