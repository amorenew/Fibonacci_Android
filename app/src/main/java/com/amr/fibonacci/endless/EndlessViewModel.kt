package com.amr.fibonacci.endless

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amr.fibonacci.Event
import com.amr.fibonacci.helpers.FibNumber
import com.amr.fibonacci.repository.ItemsRepository
import java.math.BigInteger

data class Page(val positionStart: Int, val count: Int)

class EndlessViewModel : ViewModel() {

    private val repository = ItemsRepository()
    private val list = mutableListOf<FibNumber>()

    private val _items = MutableLiveData<List<FibNumber>>().apply { value = list }
    private val _addItems = MutableLiveData<Event<Page>>()
    private val _removeItem = MutableLiveData<Event<Int>>()

    private val handler = Handler()

    private var loading = false

    private var delay = 0L

    val items: LiveData<List<FibNumber>>
        get() = _items

    val addItems: LiveData<Event<Page>>
        get() = _addItems

    val removeItem: LiveData<Event<Int>>
        get() = _removeItem

    init {
        fetchItems()
    }

    fun fetchItems() {
        if (!loading) {
            loading = true

            showLoading()

            // Simulate delay

            handler.postDelayed({

                val position = list.size
                val newItems: ArrayList<BigInteger> = if (list.size < 2)
                    repository.getItemsPage()
                else
                    repository.getItemsPage(list[list.size - 3].value, list[list.size - 2].value)

                val fibNumbers = ArrayList<FibNumber>()
                for ((index, value) in newItems.withIndex()) {
                    fibNumbers.add(FibNumber((list.size + index - 1).toLong(), value))
                }
                list.addAll(fibNumbers)

                addItems(position, newItems.size)
                removeLoading(position - 1)

                delay = if (delay == 0L) 5000 else 0
                loading = false
            }, delay)
        }
    }

    private fun showLoading() {
        list.add(FibNumber(-1))
        addItems(list.size - 1, 1)
    }

    private fun removeLoading(position: Int) {
        list.removeAt(position)
        removeItems(position)
    }

    private fun addItems(positionStart: Int, count: Int) {
        _addItems.value = Event(Page(positionStart, count))
    }

    private fun removeItems(positionStart: Int) {
        _removeItem.value = Event(positionStart)
    }
}