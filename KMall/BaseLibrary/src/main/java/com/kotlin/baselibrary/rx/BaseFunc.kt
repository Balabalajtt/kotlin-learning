package com.kotlin.baselibrary.rx

import com.kotlin.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * Created by 江婷婷 on 2018/3/10.
 */
class BaseFunc<T>: Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }
}