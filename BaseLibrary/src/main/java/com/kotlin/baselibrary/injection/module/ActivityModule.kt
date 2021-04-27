package com.kotlin.baselibrary.injection.module

import android.app.Activity
import com.kotlin.baselibrary.injection.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule constructor(private val mActivity: Activity){

    @Provides
    @ActivityScope
    fun provideActivity():Activity{
        return mActivity
    }
}