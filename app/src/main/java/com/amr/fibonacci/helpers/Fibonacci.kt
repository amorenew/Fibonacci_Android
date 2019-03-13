package com.amr.fibonacci.helpers

import java.math.BigInteger

class Fibonacci {
    companion object {
        fun fib(n: Long): BigInteger {
            var a = 0.toBigInteger()
            var b = 1.toBigInteger()
            var c: BigInteger
            if (n.toBigInteger() < 0.toBigInteger())
                throw Exception("n value should be positive value")
            if (n == 0.0.toLong())
                return a
            for (i in 2..n) {
                c = a + b
                a = b
                b = c
            }
            return b
        }
    }

}
