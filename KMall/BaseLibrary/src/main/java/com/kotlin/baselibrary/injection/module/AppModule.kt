package com.kotlin.baselibrary.injection.module

import android.content.Context
import com.kotlin.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by 江婷婷 on 2018/2/10.
 */
@Module
class AppModule(private var context: BaseApplication) {
    @Provides
    @Singleton
    fun providesContext() : Context {
        return context
    }
}