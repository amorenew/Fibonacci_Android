package com.amr.fibonacci.repository

import java.math.BigInteger

class ItemsRepository {

    private var nextItem = 1

    fun getItemsPage(
        previousValue1: BigInteger = 0.toBigInteger(),
        previousValue2: BigInteger = 0.toBigInteger(),
        pageSize: Int = 5
    ): List<String> {

        val items = mutableListOf<String>()
        val lastItem = nextItem + pageSize - 1

        for (i in nextItem..lastItem) {
            items.add("Item $i")
        }

        nextItem = lastItem + 1

        return items
    }
}