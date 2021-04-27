package com.kotlin.usercenter.data.service

import com.kotlin.usercenter.data.bean.LoginRepBean
import io.reactivex.rxjava3.core.Observable

interface UserService {
    fun login(userId:String,pwd:String): Observable<LoginRepBean>
}