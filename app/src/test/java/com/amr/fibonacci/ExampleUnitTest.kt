package com.amr.fibonacci

import com.amr.fibonacci.helpers.Fibonacci
import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigInteger


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
//    @Test
//    fun fibonacci_is_correct2() {
//        assertEquals(Fibonacci.fib(2000),0)
//        fibb.fibsStartFrom(Long.MAX_VALUE -1, Long.MAX_VALUE).test().assertValue(0)
//    }

    @Test
    fun fibonacci_is_correct() {
//        assertEquals(Fibonacci.fib(0), 0)
//        assertEquals(Fibonacci.fib(1), 1)
        assertEquals(Fibonacci.fib(8), 21.toBigInteger())
        assertEquals(Fibonacci.fib(9), 34.toBigInteger())
        assertEquals(Fibonacci.fib(9, 13.toBigInteger(), 21.toBigInteger()), 34.toBigInteger())

        assertEquals(Fibonacci.fib2(9.toBigInteger()), 34.toBigInteger())
    }

    @Test
    fun fibonacci22() {
        val intarr = Array<BigInteger>(5) {
            0.toBigInteger()
            1.toBigInteger()
            1.toBigInteger()
            2.toBigInteger()
            3.toBigInteger()
            5.toBigInteger()
            8.toBigInteger()
            13.toBigInteger()
            21.toBigInteger()
            34.toBigInteger()
        }
        //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        assertEquals(Fibonacci.fib3(9.toBigInteger()).size, 11)

        assertEquals(Fibonacci.fib3(9.toBigInteger())[5], intarr[5])
    }
//
//    @Test(expected = Exception::class)
//    fun fibonacci_negative_exception() {
//        Fibonacci.fib(-1)
//    }

}
