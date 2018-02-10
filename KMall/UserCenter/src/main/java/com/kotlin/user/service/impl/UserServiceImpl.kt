package com.kotlin.user.service.impl

import android.widget.Toast
import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.baselibrary.rx.BaseException
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.service.UserService
import com.kotlin.user.ui.activity.RegisterActivity
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * Created by 江婷婷 on 2018/2/2.
 */
class UserServiceImpl @Inject constructor(): UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {

        return repository.register(mobile, verifyCode, pwd)
                .flatMap(Func1<BaseResp<String>, Observable<Boolean>> { t ->
                    if (t.status != 0) {
                        return@Func1 Observable.error(BaseException(t.status, t.message))
                    }
                    Observable.just(true)
                })
    }

}