package com.sun.training.ut.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.sun.training.ut.R
import com.sun.training.ut.data.model.Exercise
import com.sun.training.ut.databinding.AdapterItemExerciseBinding
import com.sun.training.ut.ui.base.BaseRecyclerAdapter

class HomeAdapter(private val listener: HomeItemClickListener) :
    BaseRecyclerAdapter<Exercise<*>>(callBack = object : DiffUtil.ItemCallback<Exercise<*>>() {
        override fun areItemsTheSame(oldItem: Exercise<*>, newItem: Exercise<*>): Boolean =
            oldItem.clz == newItem.clz

        override fun areContentsTheSame(oldItem: Exercise<*>, newItem: Exercise<*>): Boolean =
            oldItem.title == newItem.title
    }) {
    override fun createBinding(parent: ViewGroup, viewType: Int?): ViewDataBinding =
        DataBindingUtil.inflate<AdapterItemExerciseBinding>(LayoutInflater.from(parent.context), R.layout.adapter_item_exercise, parent, false)

    override fun bind(binding: ViewDataBinding, item: Exercise<*>) {
        if (binding is AdapterItemExerciseBinding) {
            binding.item = item
            binding.listener = listener
        }
    }
}

interface HomeItemClickListener {
    fun onHomeItemClicked(item: Exercise<*>)
}
