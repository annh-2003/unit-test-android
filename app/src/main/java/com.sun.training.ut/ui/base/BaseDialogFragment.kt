package com.sun.training.ut.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment

/**
 * Base DialogFragment
 */
abstract class BaseDialogFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel> :
    DialogFragment() {

    //Binding view
    protected lateinit var viewBinding: ViewBinding

    //ViewModel using in screen
    protected abstract val viewModel: ViewModel

    //Variable is declare on binding view, example BR.viewModel
    protected abstract val bindingVariable: Int

    //LayoutId of screen, example R.layout.screen
    @get:LayoutRes
    protected abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (::viewBinding.isInitialized.not()) {
            viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            viewBinding.apply {
                setVariable(bindingVariable, viewModel)
                root.isClickable = true
                lifecycleOwner = viewLifecycleOwner
                executePendingBindings()
            }
        }
        return viewBinding.root
    }
}
