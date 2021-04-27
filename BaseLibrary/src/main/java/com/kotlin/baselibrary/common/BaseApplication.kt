package com.kotlin.baselibrary.common

import android.app.Application
import com.kotlin.baselibrary.injection.component.AppComponent
import com.kotlin.baselibrary.injection.component.DaggerAppComponent
import com.kotlin.baselibrary.injection.module.AppModule

class BaseApplication : Application() {
    lateinit var mAppComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        context = this
        injection()

    }

    private fun injection() {
        mAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var context: BaseApplication

    }

}