package com.kotlin.baselibrary.data.net

import com.kotlin.baselibrary.common.BaseConstants
import com.kotlin.baselibrary.data.net.intenceptor.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
/**
 * create by SunHao in 2021/4/26
 *
 * @Description : retrofit
 **/
class RetrofitFactory private constructor(){
    private lateinit var mRetrofit: Retrofit
    companion object{
        val instance by lazy { RetrofitFactory() }
    }

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BaseConstants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }

    private fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .writeTimeout(10,TimeUnit.SECONDS)
            .addInterceptor(getLogInterceptor())
            .addInterceptor(TokenInterceptor())
            .build()
    }

    private fun getLogInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }
    /*返回apiservice*/
    fun <T> create(api:Class<T>):T{
        return mRetrofit.create(api)
    }
}