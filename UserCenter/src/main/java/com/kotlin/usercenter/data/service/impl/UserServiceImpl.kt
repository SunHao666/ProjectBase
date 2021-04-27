package com.kotlin.usercenter.data.service.impl

import com.kotlin.baselibrary.ext.covert
import com.kotlin.usercenter.data.bean.LoginRepBean
import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.data.service.UserService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * create by SunHao in 2021/4/26
 *
 * @Description : 数据转换
 **/
class UserServiceImpl @Inject constructor():UserService {
    @Inject
    lateinit var userRepository:UserRepository

    override fun login(userId: String, pwd: String): Observable<LoginRepBean> {
        return userRepository.login(userId,pwd).covert()
    }
}