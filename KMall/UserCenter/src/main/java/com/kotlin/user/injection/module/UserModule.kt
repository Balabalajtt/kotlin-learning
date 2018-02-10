package com.kotlin.user.injection.module

import com.kotlin.user.service.UserService
import com.kotlin.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by 江婷婷 on 2018/2/10.
 */
@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl) : UserService {
        return service
    }

}