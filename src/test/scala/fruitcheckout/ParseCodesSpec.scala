package fruitcheckout

import org.scalactic.TypeCheckedTripleEquals._
import org.scalatest.{Matchers, FunSpec}

/**
 * Created by Kevin on 10/06/2015.
 */
class ParseCodesSpec extends FunSpec with Matchers {
  describe("code list parsing") {
    it("shouldn't crash on an empty input") {
      ParseCodes(Nil) shouldBe empty
    }

    it("shouldn't crash on invalid input") {
      ParseCodes(List("plum", "pomegranite")) shouldBe empty
    }

    it("should aggregate a repeat item and subtotal") {
      ParseCodes(List("apple", "apple")) should === (List(ReceiptLine(Produce.apple, 2, BigDecimal("1.20"))))
    }

    it("should aggregate multiple repeat items and subtotal") {
      val input = List(
        "apple",
        "orange",
        "apple",
        "orange",
        "apple")

      val expected = List(
        ReceiptLine(Produce.orange, 2, BigDecimal("0.50")),
        ReceiptLine(Produce.apple, 3, BigDecimal("1.80"))
      )
      ParseCodes(input) should contain theSameElementsAs (expected)
    }

    it("should aggregate multiple repeat items and skip junk") {
      val input = List(
        "apple",
        "orange",
        "slippers",
        "apple",
        "grapes",
        "orange",
        "cinnamon",
        "apple",
        "blender"
      )

      val expected = List(
        ReceiptLine(Produce.orange, 2, BigDecimal("0.50")),
        ReceiptLine(Produce.apple, 3, BigDecimal("1.80"))
      )
      ParseCodes(input) should contain theSameElementsAs (expected)
    }
  }
}
