package com.kotlin.baselibrary.data.net.intenceptor

import com.kotlin.baselibrary.common.BaseConstants
import okhttp3.Interceptor
import okhttp3.Response
/**
 * create by SunHao in 2021/4/26
 *
 * @Description : token拦截器
 **/
class TokenInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = chain?.request()
        val build = request?.newBuilder()?.addHeader(BaseConstants.TOKEN, "")?.build()
        return chain!!.proceed(build)
    }
}