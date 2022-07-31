package com.sun.training.ut.ui.exercise_eight

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.sun.training.ut.R
import com.sun.training.ut.databinding.ItemDayOfWeekBinding
import com.sun.training.ut.ui.base.BaseViewHolder

class DayOfWeekAdapter(
    private val clickCallback: ((String?, Int) -> Unit)?,
    private val layoutManager: RecyclerView.LayoutManager
) : RecyclerView.Adapter<BaseViewHolder<ViewDataBinding>>() {

    var listItem: ArrayList<String>? = null
    var currentItem: Int = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ViewDataBinding> {
        return BaseViewHolder(createBinding(parent))
    }

    override fun getItemCount(): Int {
        return listItem?.size ?: 0
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        val binding = holder.binding as ItemDayOfWeekBinding
        binding.item = listItem?.getOrNull(position)
        binding.clickListener = View.OnClickListener {
            if (position != currentItem) {
                selectItem(position)
            }
        }
        binding.root.isSelected = currentItem == position
    }

    fun createBinding(parent: ViewGroup): ViewDataBinding {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding
        binding = DataBindingUtil.inflate<ItemDayOfWeekBinding>(
            inflater,
            R.layout.item_day_of_week, parent, false
        )
        return binding
    }

    fun selectItem(index: Int?) {
        if (index == null) return

        if (index >= 0 && index < listItem?.size ?: 0 && index != currentItem) {
            val v = layoutManager.findViewByPosition(currentItem)

            if (v != null) {
                v.isSelected = false
            }
            currentItem = index
            layoutManager.findViewByPosition(currentItem)?.isSelected = true

            clickCallback?.invoke(listItem?.getOrNull(index), index)
        }
    }

    fun selectItem(day: String?) {
        day?.let {
            val index = listItem?.indexOf(day) ?: -1

            if (index >= 0 && index < listItem?.size ?: 0 && index != currentItem) {
                val v = layoutManager.findViewByPosition(currentItem)

                if (v != null) {
                    v.isSelected = false
                }
                currentItem = index
                layoutManager.findViewByPosition(currentItem)?.isSelected = true
            }
        }
    }
}