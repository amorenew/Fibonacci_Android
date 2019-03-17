package com.amr.fibonacci.repository

import com.amr.fibonacci.helpers.Fibonacci
import java.math.BigInteger

class ItemsRepository {

    fun getItemsPage(
        previousValue1: BigInteger = 0.toBigInteger(),
        previousValue2: BigInteger = 0.toBigInteger(),
        pageSize: Int = 100
    ): ArrayList<BigInteger> {
        return Fibonacci.generateFibonacciArray(pageSize, previousValue1, previousValue2)
    }
}