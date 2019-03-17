package com.amr.fibonacci

import com.amr.fibonacci.helpers.FibonacciHelper
import org.junit.Assert.assertEquals
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun fibonacci_generate_number() {
        assertEquals(FibonacciHelper.generateFibonacciNumber(8), 21.toBigInteger())
        assertEquals(FibonacciHelper.generateFibonacciNumber(9), 34.toBigInteger())
        assertEquals(
            FibonacciHelper.generateFibonacciNumber(9, 13.toBigInteger(), 21.toBigInteger()),
            34.toBigInteger()
        )
    }



    @Test
    fun fibonacc_generate_array() {
        val fibArray = arrayOf(
            0.toBigInteger(),//n=0
            1.toBigInteger(),//n=1
            1.toBigInteger(),//n=2
            2.toBigInteger(),//n=3
            3.toBigInteger(),//n=4
            5.toBigInteger(),//n=5
            8.toBigInteger(),//n=6
            13.toBigInteger(),//n=7
            21.toBigInteger(),//n=8
            34.toBigInteger()//n=9
        )

        assertEquals(FibonacciHelper.generateFibonacciArray(4, 3.toBigInteger(), 5.toBigInteger())[1], fibArray[7])
        assertEquals(FibonacciHelper.generateFibonacciArray(7)[6], fibArray[6])
    }

    @Test(expected = Exception::class)
    fun fibonacci_negative_exception() {
        FibonacciHelper.generateFibonacciNumber(-1)
    }

}
