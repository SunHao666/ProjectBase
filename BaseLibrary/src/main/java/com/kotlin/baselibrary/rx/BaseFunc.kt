package com.kotlin.baselibrary.rx

import com.kotlin.baselibrary.common.ResultCode
import com.kotlin.baselibrary.data.bean.BaseRep
import com.kotlin.baselibrary.data.exception.BaseException
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Function

class BaseFunc<T>: Function<BaseRep<T>,Observable<T>> {
    override fun apply(t: BaseRep<T>): Observable<T> {
        return if(t.status != ResultCode.SUCCESS){
            Observable.error(BaseException(t.msg,t.status))
        }else{
            Observable.just(t.data)
        }
    }
}