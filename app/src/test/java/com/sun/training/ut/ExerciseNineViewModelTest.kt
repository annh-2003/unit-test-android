package com.sun.training.ut

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sun.training.ut.ui.exercise_nine.ExerciseNineViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExerciseNineViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: ExerciseNineViewModel

    @Before
    fun setup(){
        viewModel = ExerciseNineViewModel()
    }

    @Test
    fun `testAttackBoss with all item success`() {
        viewModel.duaPhep.value = true
        viewModel.quanSu.value = true
        viewModel.chiaKhoaBongDem.value = true
        viewModel.kiemAnhSang.value = true
        viewModel.attackBoss()
        assertEquals("Danh bai boss thanh cong!", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss without dua phep success`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = true
        viewModel.chiaKhoaBongDem.value = true
        viewModel.kiemAnhSang.value = true
        viewModel.attackBoss()
        assertEquals("Danh bai boss thanh cong!", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss without quan su success`() {
        viewModel.duaPhep.value = true
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = true
        viewModel.kiemAnhSang.value = true
        viewModel.attackBoss()
        assertEquals("Danh bai boss thanh cong!", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with dua phep fail`() {
        viewModel.duaPhep.value = true
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = false
        viewModel.kiemAnhSang.value = false
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with quan su fail`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = true
        viewModel.chiaKhoaBongDem.value = false
        viewModel.kiemAnhSang.value = false
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with dua phep and quan su fail`() {
        viewModel.duaPhep.value = true
        viewModel.quanSu.value = true
        viewModel.chiaKhoaBongDem.value = false
        viewModel.kiemAnhSang.value = false
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with dua phep and chia khoa bong dem fail`() {
        viewModel.duaPhep.value = true
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = true
        viewModel.kiemAnhSang.value = false
        viewModel.attackBoss()
        assertEquals("Thieu kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with dua phep and kiem anh sang fail`() {
        viewModel.duaPhep.value = true
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = false
        viewModel.kiemAnhSang.value = true
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with quan su and chia khoa bong dem fail`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = true
        viewModel.chiaKhoaBongDem.value = true
        viewModel.kiemAnhSang.value = false
        viewModel.attackBoss()
        assertEquals("Thieu kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with quan su and kiem anh sang fail`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = true
        viewModel.chiaKhoaBongDem.value = false
        viewModel.kiemAnhSang.value = true
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with chia khoa bong dem and kiem anh sang fail`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = true
        viewModel.kiemAnhSang.value = true
        viewModel.attackBoss()
        assertEquals("Thieu dua phep hoac quan su de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with chia khoa bong dem fail`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = true
        viewModel.kiemAnhSang.value = false
        viewModel.attackBoss()
        assertEquals("Thieu kiem anh sang & dua phep hoac quan su de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with kiem anh sang fail`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = false
        viewModel.kiemAnhSang.value = true
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & dua phep hoac quan su de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss without all item empty`() {
        viewModel.duaPhep.value = false
        viewModel.quanSu.value = false
        viewModel.chiaKhoaBongDem.value = false
        viewModel.kiemAnhSang.value = false
        viewModel.attackBoss()
        assertEquals("Ban khong co item nao de danh boss", viewModel.message.value)
    }
}