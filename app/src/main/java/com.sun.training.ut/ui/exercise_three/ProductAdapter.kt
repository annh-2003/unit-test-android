package com.sun.training.ut.ui.exercise_three

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.training.ut.databinding.ItemSanphamBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val mListProduct = mutableListOf<Product>()
    var clickAddCount : ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val viewBinding = ItemSanphamBinding.inflate(LayoutInflater.from(parent.context))
        return ProductViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(mListProduct[position] , position)
    }

    override fun getItemCount(): Int {
        return mListProduct.size
    }

    fun setList(listSanPham: List<Product>) {
        mListProduct.apply {
            clear()
            addAll(listSanPham)
            notifyDataSetChanged()
        }
    }

    inner class ProductViewHolder(
        val viewBinding : ItemSanphamBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(sanPham: Product, position: Int) {
            viewBinding.apply {
                tvNameProduct.text = sanPham.nameOfProduct
                tvMonney.text = sanPham.priceOfProduct.toString()
                tvCount.text = sanPham.countOfProduct.toString()
                imgAddCount.setOnClickListener {
                    clickAddCount?.invoke(position)
                }
            }
        }
    }
}