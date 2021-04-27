package com.kotlin.baselibrary.ui.activity

import android.os.Bundle
import com.kotlin.base.widgets.ProgressLoading
import com.kotlin.baselibrary.common.BaseApplication
import com.kotlin.baselibrary.injection.component.ActivityComponent
import com.kotlin.baselibrary.injection.component.DaggerActivityComponent
import com.kotlin.baselibrary.injection.module.ActivityModule
import com.kotlin.baselibrary.injection.module.LifecycleProviderModule
import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.baselibrary.presenter.view.BaseView
import org.jetbrains.anko.toast
import javax.inject.Inject

abstract class BaseMVPActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    @Inject
    lateinit var mPresenter: T

    lateinit var mActivityComponent: ActivityComponent

    val progressLoading by lazy { ProgressLoading.create(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).mAppComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()

        initView()
        injectComponent()
        loadData()
    }

    abstract fun injectComponent()

    abstract fun getLayoutId(): Int

    /*初始化布局*/
    abstract fun initView()

    /*加载数据*/
    private fun loadData() {

    }

    override fun showLoading() {
        progressLoading.showLoading()
    }

    override fun hideLoading() {
        progressLoading.hideLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }

}