package com.kotlin.usercenter.data.api

import com.kotlin.baselibrary.data.bean.BaseRep
import com.kotlin.usercenter.data.bean.LoginRepBean
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserCenterService {
    /*登录*/
    @GET("user/auth")
    fun login(
        @Query("userId") userId: String,
        @Query("password") password: String
    ): Observable<BaseRep<LoginRepBean>>
}