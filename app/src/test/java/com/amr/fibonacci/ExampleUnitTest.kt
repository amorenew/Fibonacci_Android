package com.amr.fibonacci

import com.amr.fibonacci.helpers.Fibonacci
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
//    fun fibonacci_is_correct2() {
//        assertEquals(Fibonacci.fib(2000),0)
//        fibb.fibsStartFrom(Long.MAX_VALUE -1, Long.MAX_VALUE).test().assertValue(0)
//    }

    fun fibonacci_is_correct() {
//        assertEquals(Fibonacci.fib(0), 0)
//        assertEquals(Fibonacci.fib(1), 1)
        assertEquals(Fibonacci.fib(9), 34.toBigInteger())
    }
//
//    @Test(expected = Exception::class)
//    fun fibonacci_negative_exception() {
//        Fibonacci.fib(-1)
//    }

}
