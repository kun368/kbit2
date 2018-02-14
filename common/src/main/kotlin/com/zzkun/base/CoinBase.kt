package com.zzkun.base


enum class TradeSite(chsName: String) {
    HUOBI("火币"),
    OKEX("OK比特币"),
    BINANCE("币安")
}


class Currency(name: String) {
    companion object {
        val aliasList = mapOf(
                "USDT" to setOf("USDT", "USD", "US"),
                "CNY" to setOf("CNY", "RMB")
        )
    }

    private val name = normalize(name)

    private fun normalize(name: String): String {
        if (name.isBlank()) return ""
        val up = name.trim().toUpperCase()
        for ((k, v) in aliasList)
            if (up in v) return k
        return up
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Currency
        if (name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun toString(): String {
        return "Currency(name='$name')"
    }
}


data class Symbol(val quote: Currency, val base: Currency) {
    fun toStdStr() = "$quote/$base"
}
