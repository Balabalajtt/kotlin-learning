package com.kotlin.baselibrary.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * Created by 江婷婷 on 2018/2/10.
 */
@Module
class ActivityModule(private var activity: Activity) {
    @Provides
    fun providesActivity() : Activity {
        return activity
    }
}