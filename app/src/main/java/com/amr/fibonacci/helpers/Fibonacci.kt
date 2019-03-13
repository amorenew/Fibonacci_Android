package com.amr.fibonacci.helpers

class Fibonacci {
    companion object {
        fun fib(n: Long): Long {
            var a = 0.0.toLong()
            var b = 1.0.toLong()
            var c: Long
            if (n < 0.toLong())
                throw Exception("n value should be positive value")
            if (n == 0.toLong())
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
