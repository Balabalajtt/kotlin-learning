package com.kotlin.user.injection.component

import com.kotlin.baselibrary.injection.PerComponentScope
import com.kotlin.baselibrary.injection.component.ActivityComponent
import com.kotlin.user.injection.module.UserModule
import com.kotlin.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by 江婷婷 on 2018/2/10.
 */
@PerComponentScope
@Component(modules = arrayOf(UserModule::class), dependencies = arrayOf(ActivityComponent::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
}