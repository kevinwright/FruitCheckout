package fruitcheckout

import org.scalactic.TypeCheckedTripleEquals._
import org.scalatest.{Matchers, FunSpec}

class SpecialOffersSpec extends FunSpec with Matchers {
  describe("bogoff apples") {
    it("doesn't apply to one apple") {
      val receipt = Checkout.calcReceipt(List("apple"))
      receipt should contain only (
        ReceiptLine(Produce.apple, 1)
      )
    }
    it("applies once to two apples") {
      val receipt = Checkout.calcReceipt(List.fill(2)("apple"))
      receipt should contain only (
        ReceiptLine(Produce.apple, 2),
        ReceiptLine(SpecialOffers.freeApple, 1)
      )
    }
    it("applies once to three apples") {
      val receipt = Checkout.calcReceipt(List.fill(3)("apple"))
      receipt should contain only (
        ReceiptLine(Produce.apple, 3),
        ReceiptLine(SpecialOffers.freeApple, 1)
      )
    }
    it("applies twice to four apples") {
      val receipt = Checkout.calcReceipt(List.fill(4)("apple"))
      receipt should contain only (
        ReceiptLine(Produce.apple, 4),
        ReceiptLine(SpecialOffers.freeApple, 2)
      )
    }
  }
  describe("three for two oranges") {
    it("doesn't apply to one orange") {
      val receipt = Checkout.calcReceipt(List("orange"))
      receipt should contain only (
        ReceiptLine(Produce.orange, 1)
      )
    }
    it("doesn't apply to two oranges") {
      val receipt = Checkout.calcReceipt(List.fill(2)("orange"))
      receipt should contain only (
        ReceiptLine(Produce.orange, 2)
        )
    }
    it("applies once to three oranges") {
      val receipt = Checkout.calcReceipt(List.fill(3)("orange"))
      receipt should contain only (
        ReceiptLine(Produce.orange, 3),
        ReceiptLine(SpecialOffers.freeOrange, 1)
      )
    }
    it("applies once to four oranges") {
      val receipt = Checkout.calcReceipt(List.fill(4)("orange"))
      receipt should contain only (
        ReceiptLine(Produce.orange, 4),
        ReceiptLine(SpecialOffers.freeOrange, 1)
      )
    }
    it("applies once to five oranges") {
      val receipt = Checkout.calcReceipt(List.fill(5)("orange"))
      receipt should contain only (
        ReceiptLine(Produce.orange, 5),
        ReceiptLine(SpecialOffers.freeOrange, 1)
      )
    }
    it("applies twice to six oranges") {
      val receipt = Checkout.calcReceipt(List.fill(6)("orange"))
      receipt should contain only (
        ReceiptLine(Produce.orange, 6),
        ReceiptLine(SpecialOffers.freeOrange, 2)
      )
    }
  }
}
