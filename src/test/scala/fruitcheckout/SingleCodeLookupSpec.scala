package fruitcheckout

import org.scalactic.TypeCheckedTripleEquals._
import org.scalatest.FunSpec


class SingleCodeLookupSpec extends FunSpec {
  describe("code matcher") {
    describe("given a valid code") {
      it("should match all-lowercase") {
        assert(SingleCodeLookup("apple") === Some(Produce.apple))
      }
      it("should match all-uppercase") {
        assert(SingleCodeLookup("APPLE")  === Some(Produce.apple))
      }
      it("should match mixed-case") {
        assert(SingleCodeLookup("oRaNgE") === Some(Produce.orange))
      }
    }
    describe("given an invalid code") {
      it("fail on an empty string") {
        assert(SingleCodeLookup("") === None)
      }
      it("fail on an unknown item") {
        assert(SingleCodeLookup("Mango") === None)
      }
    }
  }

}
