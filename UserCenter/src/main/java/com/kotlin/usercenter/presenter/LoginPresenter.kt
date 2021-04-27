package com.kotlin.usercenter.presenter

import android.content.Context
import android.widget.Toast
import com.kotlin.base.utils.NetWorkUtils
import com.kotlin.baselibrary.ext.execute
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.rx.BaseObserver
import com.kotlin.usercenter.data.bean.LoginRepBean
import com.kotlin.usercenter.data.service.UserService
import com.kotlin.usercenter.data.service.impl.UserServiceImpl
import com.kotlin.usercenter.presenter.view.LoginView
import com.kotlin.usercenter.utils.UserPrefsUtils
import javax.inject.Inject

class LoginPresenter @Inject constructor():BasePresenter<LoginView>() {
    @Inject
    lateinit var userService:UserService

    fun login(userId:String,pwd:String) {
        if(!NetWorkUtils.isNetWorkAvailable(context)){
            mView.onError("网络连接失败")
            return
        }
        mView.showLoading()
        userService.login(userId,pwd).execute(object : BaseObserver<LoginRepBean>(mView){
            override fun onNext(t: LoginRepBean) {
                UserPrefsUtils.putUserInfo(t)
                mView.onLoginResult(t)
            }
        },lifecycleProvider)
    }

}