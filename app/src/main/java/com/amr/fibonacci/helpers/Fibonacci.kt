package com.amr.fibonacci.helpers

import java.math.BigInteger

class Fibonacci {
    companion object {
        fun fib(n: Long, value1: BigInteger = 0.toBigInteger(), value2: BigInteger = 0.toBigInteger()): BigInteger {
            var a = 0.toBigInteger()
            var b = 1.toBigInteger()
            var c: BigInteger
            if (n.toBigInteger() < 0.toBigInteger())
                throw Exception("n value should be positive value")
            if (n == 0.0.toLong())
                return a

//            var start = 2.0.toLong()

            if (value1 > 0.toBigInteger() && value2 > 0.toBigInteger())
                return value1 + value2

            for (i in 2..n) {
                c = a + b
                a = b
                b = c
            }
            return b
        }

        fun fib2(n: BigInteger): BigInteger {
            /* Declare an array to store Fibonacci numbers. */
            val f = arrayOfNulls<BigInteger>(n.toInt() + 2) // 1 extra to handle case, n = 0
            var i: BigInteger

            /* 0th and 1st number of the series are 0 and 1*/
            f[0] = 0.toBigInteger()
            f[1] = 1.toBigInteger()

            i = 2.toBigInteger()
            while (i <= n) {
                /* Add the previous 2 numbers in the series
         and store it */
                f[i.toInt()] = f[i.toInt() - 1]!! + f[i.toInt() - 2]!!
                i++
            }

            return f[n.toInt()]!!
        }

        fun fib3(n: BigInteger): Array<BigInteger?> {
            /* Declare an array to store Fibonacci numbers. */
            val f = arrayOfNulls<BigInteger>(n.toInt() + 2) // 1 extra to handle case, n = 0

            /* 0th and 1st number of the series are 0 and 1*/
            f[0] = 0.toBigInteger()
            f[1] = 1.toBigInteger()

            var i = 2.toBigInteger()
            while (i <= n) {
                /* Add the previous 2 numbers in the series
         and store it */
                f[i.toInt()] = f[i.toInt() - 1]!! + f[i.toInt() - 2]!!
                i++
            }

            return f
        }

    }

}
