package com.kotlin.baselibrary.presenter

import android.content.Context
import com.kotlin.baselibrary.presenter.view.BaseView
import com.trello.rxlifecycle4.LifecycleProvider
import javax.inject.Inject

open class BasePresenter<T:BaseView> {
    lateinit var mView:T

    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

}