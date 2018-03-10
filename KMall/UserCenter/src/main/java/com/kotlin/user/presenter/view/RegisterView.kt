package com.kotlin.user.presenter.view

import com.kotlin.baselibrary.presenter.view.BaseView

/**
 * Created by 江婷婷 on 2018/2/1.
 */
interface RegisterView: BaseView {
    fun onRegisterResult(result: String)
}