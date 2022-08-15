package com.sun.training.ut.ui.exercise_three

object ListProduct {

    fun getListProduct(): List<Product> {
        val product1 = Product(0, "Áo sơ mi trắng", 260000 , 1)
        val product2 = Product(1, "Cà vạt", 180000 , 1)
        val product3 = Product(2, "Quần bơi", 150000 , 1)
        val product4 = Product(3, "Áo vest đen", 1200000 , 1)
        val product5 = Product(4, "Quần tây đen", 750000 , 1)
        val product6 = Product(5, "Áo sơ mi đen", 190000 , 1)
        val product7 = Product(6, "Nón cối", 450000 , 1)
        val product8 = Product(7, "Dép tông lào", 190000 , 1)
        val product9 = Product(8, "Điều cầy thượng hang", 300000 , 1)
        val product10 = Product(9, "Dép tổ ông", 25000 , 1)
        return arrayListOf(product1, product2, product3, product4, product5, product6, product7 , product8 , product9, product10)
    }

    fun getListProductTestCaseOne(): List<Product> {
        val product2= Product(10, "Cà vạt", 180000 , 1)
        val product3 = Product(2, "Quần bơi", 150000 , 1)
        val product4 = Product(3, "Áo vest đen", 1200000 , 1)
        val product5 = Product(4, "Quần tây đen", 750000 , 1)
        val product6 = Product(5, "Áo sơ mi đen", 190000 , 1)
        val product7 = Product(6, "Nón cối", 450000 , 1)
        val product8 = Product(7, "Dép tông lào", 190000 , 1)
        val product9 = Product(8, "Điều cầy thượng hang", 300000 , 1)
        val product10 = Product(9, "Dép tổ ông", 25000 , 1)
        return arrayListOf(product2, product3, product4, product5, product6, product7 , product8 , product9, product10)
    }

    fun getListProductTestCaseTwo() : List<Product> {
        val product1 = Product(0, "Áo sơ mi trắng", 260000 , 1)
        val product2 = Product(1, "Cà vạt", 180000 , 1)
        val product3 = Product(2, "Quần bơi", 150000 , 1)
        return arrayListOf(product1, product2, product3)
    }

    fun getListProductTestCaseFour(): List<Product> {
        val product5 = Product(4, "Quần tây đen", 750000 , 1)
        val product6 = Product(5, "Áo sơ mi đen", 190000 , 1)
        val product7 = Product(6, "Nón cối", 450000 , 1)
        val product8 = Product(7, "Dép tông lào", 190000 , 1)
        val product9 = Product(8, "Điều cầy thượng hang", 300000 , 1)
        val product10 = Product(9, "Dép tổ ông", 25000 , 1)
        return arrayListOf(product5, product6, product7 , product8 , product9, product10)
    }
}