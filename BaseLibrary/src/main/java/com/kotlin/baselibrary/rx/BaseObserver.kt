package com.kotlin.baselibrary.rx

import com.kotlin.baselibrary.data.exception.BaseException
import com.kotlin.baselibrary.presenter.view.BaseView
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

open class BaseObserver<T>(private val mView:BaseView):Observer<T> {
    override fun onComplete() {
        mView.hideLoading()
    }

    override fun onSubscribe(d: Disposable?) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable?) {
        mView.hideLoading()
        if(e is BaseException){
            mView.onError(e.msg)
        }
    }
}