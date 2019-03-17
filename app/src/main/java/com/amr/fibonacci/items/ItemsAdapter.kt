@file:JvmName("ItemsAdapter")

package com.amr.fibonacci.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.amr.fibonacci.R
import com.amr.fibonacci.databinding.ItemViewBinding
import com.amr.fibonacci.startAnimation
import kotlinx.android.synthetic.main.loading_view.view.*

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var items: List<FibNumber> = emptyList()

    private val loading = 0
    private val item = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == loading) {
            LoadingViewHolder(parent)
        } else {
            ItemViewHolder(parent)
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && items.size > position) {
            holder.bind(items[position])
        }
    }

    fun update(items: List<FibNumber>) {
        this.items = items
        notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(items: List<FibNumber>) {
            val adapter = adapter as ItemsAdapter
            adapter.update(items)
        }
    }

    override fun getItemViewType(position: Int) =
        if (items[position].position == (-1).toLong()) loading else item

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_view,
            parent,
            false
        )
    ) : ViewHolder(binding.root) {

        fun bind(item: FibNumber) {
            binding.item = item
        }
    }

    class LoadingViewHolder(
        private val parent: ViewGroup,
        view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.loading_view,
            parent,
            false
        )
    ) :
        ViewHolder(view) {

        init {
            view.imgLoading.post { view.imgLoading.drawable.startAnimation() }
        }
    }
}