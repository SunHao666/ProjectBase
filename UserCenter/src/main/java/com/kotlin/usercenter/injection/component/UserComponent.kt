package com.kotlin.usercenter.injection.component

import com.kotlin.baselibrary.injection.PerScope
import com.kotlin.baselibrary.injection.component.ActivityComponent
import com.kotlin.usercenter.injection.moudle.UserModule
import com.kotlin.usercenter.ui.activity.LoginActivity
import dagger.Component
/**
 * create by SunHao in 2021/4/26
 *
 * @Description : user模块注射器
 **/
@PerScope
@Component(modules = arrayOf(UserModule::class),dependencies = arrayOf(ActivityComponent::class))
interface UserComponent {
    fun inject(activity:LoginActivity)
}