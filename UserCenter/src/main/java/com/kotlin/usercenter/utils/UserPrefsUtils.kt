package com.kotlin.usercenter.utils

import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.baselibrary.common.BaseConstants
import com.kotlin.provider.common.ProviderConstants
import com.kotlin.usercenter.data.bean.LoginRepBean

/*
    本地存储用户相关信息
 */
object UserPrefsUtils {

    /*
        退出登录时，传入null,清空存储
     */
    fun putUserInfo(userInfo: LoginRepBean?) {
        AppPrefsUtils.putString(ProviderConstants.KEY_SP_TOKEN, userInfo?.token ?: "")
        AppPrefsUtils.putString(ProviderConstants.KEY_SP_USERNAME, userInfo?.userName ?: "")
        AppPrefsUtils.putString(ProviderConstants.KEY_SP_USERTYPE, userInfo?.userType ?: "")
    }
}
