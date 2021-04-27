package com.kotlin.baselibrary.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.baselibrary.injection.ActivityScope
import com.kotlin.baselibrary.injection.module.ActivityModule
import com.kotlin.baselibrary.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle4.LifecycleProvider
import dagger.Component

/**
 * 依赖全局的component
 */
@ActivityScope
@Component(modules = arrayOf(ActivityModule::class,LifecycleProviderModule::class),dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {
    fun context():Context
    fun activity():Activity
    fun lifeProvider():LifecycleProvider<*>
}