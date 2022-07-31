package com.sun.training.ut.data.model

data class No9Input(
    val magicWand: Boolean,
    val master: Boolean,
    val key: Boolean? = null,
    val lightSword: Boolean? = null
) : BaseModel()
