package fruitcheckout


object SingleCodeLookup extends (String => Option[Produce]) {

  val map = Map(
    "apple" -> Produce.apple,
    "orange" -> Produce.orange
  )

  override def apply(str: String): Option[Produce] = map.get(str.toLowerCase)
}
