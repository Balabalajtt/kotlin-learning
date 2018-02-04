package com.example.zfquery.base

import rx.Subscriber

/**
 * Created by 江婷婷 on 2018/2/4.
 */
open class BaseSubscriber<T> : Subscriber<T>() {
    override fun onNext(t: T) {}

    override fun onCompleted() {}

    override fun onError(e: Throwable?) {}
}