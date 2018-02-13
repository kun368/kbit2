package com.zzkun


enum class TradeSite(
        chsName: String)
{
    HUOBI("���"),
    OKEX("OK���ر�"),
    BINANCE("�Ұ�")
}

/// ====================================

class Currency(val name: String) {

}

fun String.toCurrency(): Currency {
    val aliasList = mapOf(
            "USDT" to setOf("USDT", "USD", "US"),
            "CNY"  to setOf("CNY", "RMB")
    )
    if (isBlank()) return Currency("")
    val up = trim().toUpperCase()
    for ((k, v) in aliasList)
        if (up in v)
            return Currency(k)
    return Currency(up)
}

/// ======================================

data class Symbol(val quote: Currency, val base: Currency)
