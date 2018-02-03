package com.kotlin.user.data.repository

import com.kotlin.baselibrary.data.net.RetrofitFactory
import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.user.data.api.UserApi
import com.kotlin.user.data.protocol.RegisterReq
import rx.Observable

/**
 * Created by 江婷婷 on 2018/2/2.
 */
class UserRepository {
    fun register(mobile: String, verifyCode: String, pwd: String) : Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq(mobile, verifyCode, pwd))
    }
}