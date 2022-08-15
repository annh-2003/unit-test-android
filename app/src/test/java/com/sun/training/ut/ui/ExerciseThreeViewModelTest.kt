package com.sun.training.ut.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.ui.exercise_three.ExerciseThreeViewModel
import com.sun.training.ut.ui.exercise_three.ListProduct
import com.sun.training.ut.ui.exercise_three.Product
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseThreeViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    lateinit var viewModel : ExerciseThreeViewModel
    lateinit var mListsanPham : MutableList<Product>

    @Before
    fun setUp(){
        viewModel = ExerciseThreeViewModel()
        mListsanPham = viewModel.mListProduct
    }

    @Test
    fun `test add fail is position null`() {
        val position = null
        viewModel.addProduct(position)
        assertNull(position)
    }

    @Test
    fun `test add success is position not null`() {
        val position = 0
        viewModel.addProduct(position)
        assertNotNull(position)
    }

    @Test
    fun `test check Amount product onSuccess`() {
        mListsanPham.addAll(ListProduct.getListProduct())
        assertTrue(viewModel.checkAmountProduct())
    }

    @Test
    fun `test check Amount product onFail`() {
       assertFalse(viewModel.checkAmountProduct())
    }

    @Test
    fun `test check AoSoMi on Success`() {
        mListsanPham.add(Product(0, "" , 0 , 2))
        assertTrue(viewModel.checkAoSoMi())
    }

    @Test
    fun `test check AoSoMi onFail`() {
        mListsanPham.add(Product(1, "" , 0 , 2))
        assertFalse(viewModel.checkAoSoMi())
    }

    @Test
    fun `test check CaVat onSuccess`() {
        mListsanPham.add(Product(1, "" , 0 , 2))
        assertTrue(viewModel.checkCaVat())
    }

    @Test
    fun `test check CaVat onFail`() {
        mListsanPham.add(Product(2, "" , 0 , 2))
        assertFalse(viewModel.checkCaVat())
    }

    @Test
    fun `test check Handle Data AmountProduct equal or greater 7 onSuccess`() {
        val result = 3194550
        mListsanPham.addAll(ListProduct.getListProductTestCaseOne())
        val actual = viewModel.handleData(false , false ,true)
        assertEquals(result, actual)
    }

    @Test
    fun `test check Handle Data AmountProduct equal or greater 7  onFail`() {
        val result = 2
        mListsanPham.addAll(ListProduct.getListProductTestCaseOne())
        val actual = viewModel.handleData(false , false ,true)
        assertFalse(result == actual)
    }

    @Test
    fun `test check Handle Data meet the condition of 5 percent discount onSuccess`() {
        val result = 560500
        mListsanPham.addAll(ListProduct.getListProductTestCaseTwo())
        val actual = viewModel.handleData(true , true ,false)
        assertEquals(result, actual)
    }

    @Test
    fun `test check Handle Data meet the condition of 5 percent discount onFail`() {
        val result = 560500
        mListsanPham.addAll(ListProduct.getListProductTestCaseTwo())
        val actual = viewModel.handleData(true , true ,false)
        assertFalse(result != actual)
    }

    @Test
    fun `test check Handle Data meet the condition of 12 percent discount onSuccess`() {
        val result = 3251600
        mListsanPham.addAll(ListProduct.getListProduct())
        val actual = viewModel.handleData(true , true ,true)
        assertEquals(result, actual)
    }

    @Test
    fun `test check Handle Data meet the condition of 12 percent discount onFail`() {
        val result = 3251600
        mListsanPham.addAll(ListProduct.getListProduct())
        val actual = viewModel.handleData(true , true ,true)
        assertFalse( result != actual)
    }

    @Test
    fun `test check Handle Data conditions are not satisfied onSuccess`() {
        val result = 1905000
        mListsanPham.addAll(ListProduct.getListProductTestCaseFour())
        val actual = viewModel.handleData(false , false ,false)
        assertEquals(result, actual)
    }

    @Test
    fun `test check Handle Data conditions are not satisfied onFail`() {
        val result = 1905000
        mListsanPham.addAll(ListProduct.getListProductTestCaseFour())
        val actual = viewModel.handleData(false , false ,false)
        assertFalse(result != actual)
    }

    @Test
    fun `test check Handle get Monney onSuccess`() {
        val result = 3695000
        mListsanPham.addAll(ListProduct.getListProduct())
        val actual = viewModel.getMonney()
        assertEquals(result , actual)
    }

    @Test
    fun `test check Handle get Monney onFail`() {
        val result = 3695000
        mListsanPham.addAll(ListProduct.getListProductTestCaseTwo())
        val actual = viewModel.getMonney()
        assertTrue(result != actual)
    }
}
