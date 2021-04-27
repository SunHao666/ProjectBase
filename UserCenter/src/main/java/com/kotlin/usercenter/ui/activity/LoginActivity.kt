package com.kotlin.usercenter.ui.activity

import com.kotlin.baselibrary.ui.activity.BaseMVPActivity
import com.kotlin.usercenter.R
import com.kotlin.usercenter.data.bean.LoginRepBean
import com.kotlin.usercenter.injection.component.DaggerUserComponent
import com.kotlin.usercenter.injection.moudle.UserModule
import com.kotlin.usercenter.presenter.LoginPresenter
import com.kotlin.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

/**
 * create by SunHao in 2021/4/25
 *
 * @Description : 登录
 **/
class LoginActivity : BaseMVPActivity<LoginPresenter>(), LoginView {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        mLoginBtn.setOnClickListener {
            mPresenter.login(mPhoneEt.text.toString(),mPwdEt.text.toString())
        }
    }

    override fun onLoginResult(loginRepBean: LoginRepBean) {
        toast("登录成功")
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(mActivityComponent).userModule(UserModule()).build()
            .inject(this)
        mPresenter.mView = this
    }

}