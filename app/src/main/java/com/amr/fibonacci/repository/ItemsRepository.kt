package com.amr.fibonacci.repository

import com.amr.fibonacci.helpers.FibonacciHelper
import java.math.BigInteger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemsRepository @Inject constructor() {

    fun getItemsPage(
        previousValue1: BigInteger = 0.toBigInteger(),
        previousValue2: BigInteger = 0.toBigInteger(),
        pageSize: Int = 100
    ): ArrayList<BigInteger> {
        return FibonacciHelper.generateFibonacciArray(pageSize, previousValue1, previousValue2)
    }
}