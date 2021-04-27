package com.kotlin.baselibrary.ui.activity

import android.os.Bundle
import com.kotlin.baselibrary.common.AppManager
import com.trello.rxlifecycle4.components.support.RxAppCompatActivity

open class BaseActivity: RxAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManager.instance.pushActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.removeActivity(this)
    }
}