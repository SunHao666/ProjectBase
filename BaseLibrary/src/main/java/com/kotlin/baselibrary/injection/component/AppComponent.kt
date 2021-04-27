package com.kotlin.baselibrary.injection.component

import android.content.Context
import com.kotlin.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * 全局的component
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context():Context
}