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
    fun `testAttackBoss with_all_item attack_boss_success`() {
        viewModel.magicChopstick.value = true
        viewModel.tactician.value = true
        viewModel.darknessKey.value = true
        viewModel.sword.value = true
        viewModel.attackBoss()
        assertEquals("Danh bai boss thanh cong!", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss without_magicChopstick attack_boss_success`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = true
        viewModel.darknessKey.value = true
        viewModel.sword.value = true
        viewModel.attackBoss()
        assertEquals("Danh bai boss thanh cong!", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss without_tactician attack_boss_success`() {
        viewModel.magicChopstick.value = true
        viewModel.tactician.value = false
        viewModel.darknessKey.value = true
        viewModel.sword.value = true
        viewModel.attackBoss()
        assertEquals("Danh bai boss thanh cong!", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_magicChopstick attack_boss_fail_lack_darknessKey_and_sword`() {
        viewModel.magicChopstick.value = true
        viewModel.tactician.value = false
        viewModel.darknessKey.value = false
        viewModel.sword.value = false
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_tactician attack_boss_fail_lack_darknessKey_and_sword`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = true
        viewModel.darknessKey.value = false
        viewModel.sword.value = false
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_magicChopstick_and_tactician attack_boss_fail_lack_darknessKey_and_sword`() {
        viewModel.magicChopstick.value = true
        viewModel.tactician.value = true
        viewModel.darknessKey.value = false
        viewModel.sword.value = false
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_magicChopstick_and_darknessKey attack_boss_fail_lack_sword`() {
        viewModel.magicChopstick.value = true
        viewModel.tactician.value = false
        viewModel.darknessKey.value = true
        viewModel.sword.value = false
        viewModel.attackBoss()
        assertEquals("Thieu kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_magicChopstick_and_sword attack_boss_fail_lack_darknessKey`() {
        viewModel.magicChopstick.value = true
        viewModel.tactician.value = false
        viewModel.darknessKey.value = false
        viewModel.sword.value = true
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_tactician_and_darknessKey attack_boss_fail_lack_sword`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = true
        viewModel.darknessKey.value = true
        viewModel.sword.value = false
        viewModel.attackBoss()
        assertEquals("Thieu kiem anh sang de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_tactician_and_sword attack_boss_fail_lack_darknessKey`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = true
        viewModel.darknessKey.value = false
        viewModel.sword.value = true
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_darknessKey_and_sword attack_boss_fail_magicChopstick_and_tactician`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = false
        viewModel.darknessKey.value = true
        viewModel.sword.value = true
        viewModel.attackBoss()
        assertEquals("Thieu dua phep hoac quan su de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_darknessKey attack_boss_fail_lack_sword_and_magicChopstick_or_tactician`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = false
        viewModel.darknessKey.value = true
        viewModel.sword.value = false
        viewModel.attackBoss()
        assertEquals("Thieu kiem anh sang & dua phep hoac quan su de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss with_sword attack_boss_fail_lack_darknessKey_and_magicChopstick_or_tactician`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = false
        viewModel.darknessKey.value = false
        viewModel.sword.value = true
        viewModel.attackBoss()
        assertEquals("Thieu chia khoa bong dem & dua phep hoac quan su de danh boss", viewModel.message.value)
    }

    @Test
    fun `testAttackBoss without_all_item attack_boss_fail_lack_all_item`() {
        viewModel.magicChopstick.value = false
        viewModel.tactician.value = false
        viewModel.darknessKey.value = false
        viewModel.sword.value = false
        viewModel.attackBoss()
        assertEquals("Ban khong co item nao de danh boss", viewModel.message.value)
    }
}