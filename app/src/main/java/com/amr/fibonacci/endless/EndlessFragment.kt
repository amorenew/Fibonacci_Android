package com.amr.fibonacci.endless


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.amr.fibonacci.R
import com.amr.fibonacci.databinding.FragmentEndlessBinding
import com.amr.fibonacci.items.ItemsAdapter
import com.amr.fibonacci.subscribe
import kotlinx.android.synthetic.main.fragment_endless.*

class EndlessFragment : Fragment() {

    private lateinit var binding: FragmentEndlessBinding
    private lateinit var viewModel: EndlessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_endless, container, false)

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this)[EndlessViewModel::class.java]

        val layoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager
        recyclerView.hasFixedSize()
        recyclerView.adapter = ItemsAdapter()
//        recyclerView.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))

        recyclerView.endless { viewModel.fetchItems() }

        viewModel.addItems.subscribe(this) {
            (recyclerView.adapter as ItemsAdapter).notifyItemRangeInserted(data.positionStart, data.count)
        }
        viewModel.removeItem.subscribe(this) {
            (recyclerView.adapter as ItemsAdapter).notifyItemRemoved(data)
        }

        binding.viewModel = viewModel
    }
}