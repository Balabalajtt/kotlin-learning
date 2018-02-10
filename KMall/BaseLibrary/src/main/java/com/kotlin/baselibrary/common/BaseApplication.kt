package com.kotlin.baselibrary.common

import android.app.Application
import com.kotlin.baselibrary.injection.component.AppComponent
import com.kotlin.baselibrary.injection.component.DaggerAppComponent
import com.kotlin.baselibrary.injection.module.AppModule

/**
 * Created by 江婷婷 on 2018/2/10.
 */
class BaseApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        initAppInjection()
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}