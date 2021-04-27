package com.kotlin.usercenter.injection.moudle

import com.kotlin.usercenter.data.repository.UserRepository
import com.kotlin.usercenter.data.service.UserService
import com.kotlin.usercenter.data.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    fun providerUserService(service:UserServiceImpl):UserService{
        return service
    }

    @Provides
    fun providerUserRepository():UserRepository{
        return UserRepository()
    }
}