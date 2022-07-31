package com.sun.training.ut.ui.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors

/**
 * Base RecyclerView
 * @param callBack, Callback for calculating the diff between two non-null items in a list.
 * @param <T> Type of items to compare.
 */
abstract class BaseRecyclerAdapter<T>(
    callBack: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<ViewDataBinding>>(
    AsyncDifferConfig.Builder<T>(callBack)
        .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
        .build()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewDataBinding> {
        return BaseViewHolder(createBinding(parent = parent, viewType = viewType))
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        bind(holder.binding, getItem(position))
        holder.binding.executePendingBindings()
    }

    /**
     * Binding layout
     */
    protected abstract fun createBinding(parent: ViewGroup, viewType: Int? = 0): ViewDataBinding

    /**
     * Binding variable
     */
    protected abstract fun bind(binding: ViewDataBinding, item: T)
}
