package com.sun.training.ut.ui.exercise_five

import android.content.Context
import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.sun.training.ut.R
import com.sun.training.ut.data.Constant


class SpinnerItemAdapter<T>(context: Context, layoutId: Int, data: List<T>) :
    ArrayAdapter<T>(context, layoutId, data) {
    override fun isEnabled(position: Int): Boolean {
        return position != Constant.Coupon.PIZZA_SECOND_FREE.ordinal && position != Constant.Coupon.POTATO_PROMOTION.ordinal
    }

    override fun areAllItemsEnabled(): Boolean {
        return false
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getDropDownView(position, convertView, parent)
        if (position == Constant.Coupon.PIZZA_SECOND_FREE.ordinal || position == Constant.Coupon.POTATO_PROMOTION.ordinal)
            view.findViewById<TextView>(android.R.id.text1)
                .setTextColor(context.getColor(R.color.color_gray))
        return view
    }
}