package com.sun.training.ut.ui.exercise_three

object ListProduct {

    fun getListProduct(): List<Product> {
        val sanpham1 = Product(0, "Áo sơ mi trắng", 260000 , 1)
        val sanpham2 = Product(1, "Cà vạt", 180000 , 1)
        val sanpham3 = Product(2, "Quần bơi", 150000 , 1)
        val sanpham4 = Product(3, "Áo vest đen", 1200000 , 1)
        val sanpham5 = Product(4, "Quần tây đen", 750000 , 1)
        val sanpham6 = Product(5, "Áo sơ mi đen", 190000 , 1)
        val sanpham7 = Product(6, "Nón cối", 450000 , 1)
        val sanpham8 = Product(7, "Dép tông lào", 190000 , 1)
        val sanpham9 = Product(8, "Điều cầy thượng hang", 300000 , 1)
        val sanpham10 = Product(9, "Dép tổ ông", 25000 , 1)
        return arrayListOf(sanpham1, sanpham2, sanpham3, sanpham4, sanpham5, sanpham6, sanpham7 , sanpham8 , sanpham9, sanpham10)
    }

    fun getListProductTESTTWO() : List<Product> {
        val sanpham1 = Product(0, "Áo sơ mi trắng", 260000 , 1)
        val sanpham2 = Product(1, "Cà vạt", 180000 , 1)
        val sanpham3 = Product(2, "Quần bơi", 150000 , 1)
        return arrayListOf(sanpham1, sanpham2, sanpham3)
    }

    fun getListProductTESTONE(): List<Product> {
        val sanpham2 = Product(10, "Cà vạt", 180000 , 1)
        val sanpham3 = Product(2, "Quần bơi", 150000 , 1)
        val sanpham4 = Product(3, "Áo vest đen", 1200000 , 1)
        val sanpham5 = Product(4, "Quần tây đen", 750000 , 1)
        val sanpham6 = Product(5, "Áo sơ mi đen", 190000 , 1)
        val sanpham7 = Product(6, "Nón cối", 450000 , 1)
        val sanpham8 = Product(7, "Dép tông lào", 190000 , 1)
        val sanpham9 = Product(8, "Điều cầy thượng hang", 300000 , 1)
        val sanpham10 = Product(9, "Dép tổ ông", 25000 , 1)
        return arrayListOf(sanpham2, sanpham3, sanpham4, sanpham5, sanpham6, sanpham7 , sanpham8 , sanpham9, sanpham10)
    }

    fun getListProductFOUR(): List<Product> {
        val sanpham5 = Product(4, "Quần tây đen", 750000 , 1)
        val sanpham6 = Product(5, "Áo sơ mi đen", 190000 , 1)
        val sanpham7 = Product(6, "Nón cối", 450000 , 1)
        val sanpham8 = Product(7, "Dép tông lào", 190000 , 1)
        val sanpham9 = Product(8, "Điều cầy thượng hang", 300000 , 1)
        val sanpham10 = Product(9, "Dép tổ ông", 25000 , 1)
        return arrayListOf(sanpham5, sanpham6, sanpham7 , sanpham8 , sanpham9, sanpham10)
    }

}