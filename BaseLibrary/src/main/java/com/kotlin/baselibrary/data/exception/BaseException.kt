package com.kotlin.baselibrary.data.exception

data class BaseException(val msg: String,
                         val status: Int) : Throwable()