package com.sun.training.ut.data.model

import com.sun.training.ut.ui.base.BaseActivity

/**
 * @{Exercise}
 * Created by nguyen.van.bac on 14,September,2020
 */
data class Exercise<T : BaseActivity<*, *>>(val title: String, val clz: Class<T>)