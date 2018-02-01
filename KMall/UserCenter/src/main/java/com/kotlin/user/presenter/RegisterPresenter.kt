package com.kotlin.user.presenter

import com.kotlin.baselibrary.presenter.BasePresenter
import com.kotlin.user.presenter.view.RegisterView

/**
 * Created by 江婷婷 on 2018/2/1.
 */
class RegisterPresenter: BasePresenter<RegisterView>() {
    fun register(mobile: String, verifyCode: String) {
        /*
            业务逻辑
         */
        mView.onRegisterResult(true)
    }
}