val cardType: String = "МИР"
val previousTransfer: Int = 1000_00
val currentTransfer: Int = 4000_00
var comission: Int = 0

fun comissionCalculation(cardType: String = "VKPay", previousTransfer: Int, currentTransfer: Int):Int {

    if (cardType == "Mastercard" || cardType == "Maestro" || cardType == "Visa" || cardType == "МИР") {
        if (currentTransfer > 150_000_00 || currentTransfer + previousTransfer > 600_000_00) {
            println("Вы превысили лимит переводов по карте $cardType!")
            comission = 0
        } else if (cardType == "Mastercard" || cardType == "Maestro") {
            if (currentTransfer + previousTransfer > 75000_00) {
                comission = currentTransfer / 1000 * 6 + 20_00
            } else {
                comission = 0
            }

        } else if (cardType == "Visa" || cardType == "МИР") {
            comission = currentTransfer / 10000 * 75
            //println("COMIS $comission")
            comission = if (comission > 35_00) comission else 35_00
        }


    } else if (cardType == "VKPay") {
        if (currentTransfer > 15000_00 || currentTransfer + previousTransfer > 40000_00) {
            println("Вы превысили лимит переводов по карте $cardType!")
            comission = 0
        } else {
            comission = 0
        }

    }
return comission
}


fun main() {

    val finalComission = comissionCalculation(cardType, previousTransfer, currentTransfer)
    println("Комиссия за перевод: $finalComission")

}