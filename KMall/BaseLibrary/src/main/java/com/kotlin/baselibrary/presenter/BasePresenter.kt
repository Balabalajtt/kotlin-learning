package com.kotlin.baselibrary.presenter

import com.kotlin.baselibrary.presenter.view.BaseView

/**
 * Created by 江婷婷 on 2018/2/1.
 */
open class BasePresenter<T: BaseView> {
    lateinit var mView: T
}