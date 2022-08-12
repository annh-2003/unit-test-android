package com.sun.training.ut.ui.exercise_three

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.training.ut.databinding.ItemSanphamBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val mListSanPham = mutableListOf<Product>()
    var clickAddCount : ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val viewBinding = ItemSanphamBinding.inflate(LayoutInflater.from(parent.context))
        return ProductViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(mListSanPham[position] , position)
    }

    override fun getItemCount(): Int {
        return mListSanPham.size
    }

    fun setList(listSanPham: List<Product>) {
        mListSanPham.apply {
            clear()
            addAll(listSanPham)
            notifyDataSetChanged()
        }
    }

    inner class ProductViewHolder(
        val viewBinding : ItemSanphamBinding): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(sanPham: Product, position: Int) {
            viewBinding.apply {
                tvNameSanPham.text = sanPham.nameOfProduct
                tvSoTien.text = sanPham.priceOfProduct.toString()
                tvCount.text = sanPham.countOfProduct.toString()
                imgAddCount.setOnClickListener {
                    clickAddCount?.invoke(position)
                }
            }
        }
    }
}