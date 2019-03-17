package com.amr.fibonacci.helpers

import java.math.BigInteger
import javax.inject.Inject

class FibonacciHelper @Inject constructor() {

    companion object {

        fun generateFibonacciNumber(
            n: Long,
            value1: BigInteger = 0.toBigInteger(),
            value2: BigInteger = 0.toBigInteger()
        ): BigInteger {
            var a = 0.toBigInteger()
            var b = 1.toBigInteger()
            var c: BigInteger

            if (n.toBigInteger() < 0.toBigInteger())
                throw Exception("n value should be positive value")
            if (n == 0.0.toLong())
                return a

            if (value1 > 0.toBigInteger() && value2 > 0.toBigInteger())
                return value1 + value2

            for (i in 2..n) {
                c = a + b
                a = b
                b = c
            }
            return b
        }


        fun generateFibonacciArray(
            arraySize: Int = 10,
            value1: BigInteger = 0.toBigInteger(),
            value2: BigInteger = 0.toBigInteger()
        ): ArrayList<BigInteger> {
            /* Declare an array to store FibonacciHelper numbers. */
            val f = ArrayList<BigInteger>(arraySize) // 1 extra to handle case, n = 0

            /* 0th and 1st number of the series are 0 and 1*/
            if (value1 > 0.toBigInteger() && value2 > 0.toBigInteger()) {
                f.add(value1 + value2)//index 0
                f.add(value2 + f[0])//index 1
            } else {
                f.add(0.toBigInteger())//index 0
                f.add(1.toBigInteger())//index 1
            }

            var i = 2.toBigInteger()
            while (i < arraySize.toBigInteger()) {
                /* Add the previous 2 numbers in the series
     and store it */
                f.add(i.toInt(), f[i.toInt() - 1] + f[i.toInt() - 2])
                i++
            }

            return f
        }

    }
}