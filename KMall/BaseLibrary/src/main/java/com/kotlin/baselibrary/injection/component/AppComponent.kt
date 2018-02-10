package com.kotlin.baselibrary.injection.component

import android.content.Context
import com.kotlin.baselibrary.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by 江婷婷 on 2018/2/10.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}
