package com.amr.fibonacci.items

import java.math.BigInteger
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class FibNumber(var position: Long = 0, var value: BigInteger = 0.toBigInteger()) {


    fun getPositionText(): String {
        return String.format("N: %d", position)
    }

    fun getValueText(): String {
        return if (value.toString().length > 50)
            DecimalFormat("0000000000000.#######E0", DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(
                value
            )
        else
            value.toString()
    }

}