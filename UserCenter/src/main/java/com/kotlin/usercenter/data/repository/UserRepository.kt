package com.kotlin.usercenter.data.repository

import com.kotlin.baselibrary.data.bean.BaseRep
import com.kotlin.baselibrary.data.net.RetrofitFactory
import com.kotlin.usercenter.data.api.UserCenterService
import com.kotlin.usercenter.data.bean.LoginRepBean
import io.reactivex.rxjava3.core.Observable

class UserRepository {
    fun login(userId: String, password: String): Observable<BaseRep<LoginRepBean>> {
        return RetrofitFactory.instance.create(UserCenterService::class.java).login(userId,password)
    }
}