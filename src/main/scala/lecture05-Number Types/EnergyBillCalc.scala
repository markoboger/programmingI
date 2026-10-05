// Programming I — Lecture 05: Number Types
// Calculation: BigDecimal money math as top-level values and functions

val hundred: BigDecimal = BigDecimal(100)

val consumptionBd: BigDecimal = BigDecimal(consumptionKwh)
val priceBd: BigDecimal = BigDecimal(pricePerKwh.toString)
val standingBd: BigDecimal = BigDecimal(standingChargePerMonth.toString)
val taxRateBd: BigDecimal = BigDecimal(taxRate.toString)
val monthsBd: BigDecimal = BigDecimal(months)

val energyNet: BigDecimal = consumptionBd * priceBd
val standingNet: BigDecimal = monthsBd * standingBd
val subtotalNet: BigDecimal = energyNet + standingNet
val taxAmount: BigDecimal = subtotalNet * taxRateBd
val totalGross: BigDecimal = subtotalNet + taxAmount

val averageKwhPerMonth: Double =
  consumptionKwh.toDouble / months

def toCents(amount: BigDecimal): BigInt =
  (amount * hundred)
    .setScale(0, BigDecimal.RoundingMode.HALF_UP)
    .toBigInt

def money(amount: BigDecimal): String =
  String.format(java.util.Locale.GERMANY, "%8.2f €", amount.bigDecimal)
