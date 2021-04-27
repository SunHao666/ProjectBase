package com.kotlin.baselibrary.ext

import com.kotlin.baselibrary.data.bean.BaseRep
import com.kotlin.baselibrary.rx.BaseFunc
import com.kotlin.baselibrary.rx.BaseObserver
import com.trello.rxlifecycle4.LifecycleProvider
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

fun <T> Observable<T>.execute(observer: BaseObserver<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(observer)
}

fun <T> Observable<BaseRep<T>>.covert(): Observable<T> {
    return this.flatMap(BaseFunc<T>())
}