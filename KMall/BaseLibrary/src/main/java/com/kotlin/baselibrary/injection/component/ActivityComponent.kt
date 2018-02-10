package com.kotlin.baselibrary.injection.component

import android.app.Activity
import com.kotlin.baselibrary.injection.ActivityScope
import com.kotlin.baselibrary.injection.module.ActivityModule
import dagger.Component

/**
 * Created by 江婷婷 on 2018/2/10.
 */
@ActivityScope
@Component(modules = arrayOf(ActivityModule::class), dependencies = arrayOf(AppComponent::class))
interface ActivityComponent {
    fun activity(): Activity
}