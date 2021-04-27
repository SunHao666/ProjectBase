package com.kotlin.baselibrary.injection.module

import android.content.Context
import com.kotlin.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule constructor(private val mContext: BaseApplication){
    @Provides
    @Singleton
    fun provideContext():Context{
        return mContext
    }
}