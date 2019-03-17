package com.amr.fibonacci.repository

import com.amr.fibonacci.helpers.Fibonacci
import java.math.BigInteger

class ItemsRepository {

    private var nextItem = 1

    fun getItemsPage(
        previousValue1: BigInteger = 0.toBigInteger(),
        previousValue2: BigInteger = 0.toBigInteger(),
        pageSize: Int = 100
    ): ArrayList<BigInteger> {

        return Fibonacci.fib4(pageSize, previousValue1, previousValue2)
//        val items = mutableListOf<String>()
//        val lastItem = nextItem + pageSize - 1
//
//        for (i in nextItem..lastItem) {
//            items.add("Item $i")
//        }
//
//        nextItem = lastItem + 1
//
//        return items
    }
}