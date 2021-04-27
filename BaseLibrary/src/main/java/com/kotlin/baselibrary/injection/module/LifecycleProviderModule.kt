package com.kotlin.baselibrary.injection.module

import com.trello.rxlifecycle4.LifecycleProvider
import dagger.Module
import dagger.Provides

@Module
class LifecycleProviderModule constructor(private val lifecycleProvider: LifecycleProvider<*>){
    /**
     * rxcycleProvider
     */
    @Provides
    fun providerLifecycleProvider():LifecycleProvider<*>{
        return lifecycleProvider
    }
}