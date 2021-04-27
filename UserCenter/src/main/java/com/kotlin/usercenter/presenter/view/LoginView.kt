package com.kotlin.usercenter.presenter.view

import com.kotlin.baselibrary.presenter.view.BaseView
import com.kotlin.usercenter.data.bean.LoginRepBean

interface LoginView:BaseView {
    fun onLoginResult(loginRepBean: LoginRepBean)
}