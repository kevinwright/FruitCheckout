package fruitcheckout

import org.scalactic.TypeCheckedTripleEquals._
import org.scalatest.FunSpec

class CheckoutSpec extends FunSpec {
  describe("checkout") {
    it("should correctly total codes") {
      val input = List("apple", "apple", "orange", "apple")
      assert(Checkout(input) === BigDecimal("2.05"))
    }
  }
}
