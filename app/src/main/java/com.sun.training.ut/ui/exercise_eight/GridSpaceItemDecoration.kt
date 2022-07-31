package com.sun.training.ut.ui.exercise_eight

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridSpaceItemDecoration(var space: Int = 0,
                              var span: Int = 0) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        var position = parent.getChildAdapterPosition(view) // item position
        var column = position % span // item column

        outRect.left = column * space / span // column * ((1f / span) * space)
        outRect.right =
            space - (column + 1) * space / span // space - (column + 1) * ((1f /    span) * space)
        if (position >= span) {
            outRect.top = space // item top
        }
    }
}