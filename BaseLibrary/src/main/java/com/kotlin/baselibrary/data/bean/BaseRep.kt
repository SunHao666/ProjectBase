package com.kotlin.baselibrary.data.bean

data class BaseRep<T>(val data: T,
                   val msg: String,
                   val status: Int)