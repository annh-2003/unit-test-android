package com.sun.training.ut.ui.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.play.core.splitcompat.SplitCompat

/**
 * Base Activity
 */
abstract class BaseActivity<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> :
    AppCompatActivity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.installActivity(this)
    }

    //Binding view
    protected lateinit var viewBinding: ViewBinding

    //ViewModel using in screen
    protected abstract val viewModel: ViewModel

    //Variable is declare on binding view, example BR.viewModel
    protected abstract val bindingVariable: Int

    //LayoutId of screen, example R.layout.screen
    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (::viewBinding.isInitialized.not()) {
            viewBinding = DataBindingUtil.setContentView(this, layoutId)
            viewBinding.setVariable(bindingVariable, viewModel)
        }
    }
}
