// Programming I — Lecture 05: Number Types
// Output: ASCII bill table as one multiline stripMargin string

def billTable: String =
  val taxLabel =
    f"VAT (${(taxRate * 100).toInt}%%)".padTo(16, ' ')
  val blankQty = f"${""}%8s"
  val consumptionText = f"$consumptionKwh%8d"
  val monthsText = f"$months%8d"
  val averageText =
    String.format(java.util.Locale.US, "%8.1f", averageKwhPerMonth)
  val blankAmount = f"${""}%10s"

  s"""|+------------------+----------+--------+------------+
     || Item             | Quantity | Unit   | Amount     |
     |+------------------+----------+--------+------------+
     || Energy (net)     | $consumptionText | kWh    | ${money(energyNet)} |
     || Standing (net)   | $monthsText | months | ${money(standingNet)} |
     || Subtotal (net)   | $blankQty |        | ${money(subtotalNet)} |
     || $taxLabel | $blankQty |        | ${money(taxAmount)} |
     || Avg. consumption | $averageText | kWh/mo | $blankAmount |
     |+------------------+----------+--------+------------+
     || Total (gross)    | $blankQty |        | ${money(totalGross)} |
     |+------------------+----------+--------+------------+""".stripMargin
