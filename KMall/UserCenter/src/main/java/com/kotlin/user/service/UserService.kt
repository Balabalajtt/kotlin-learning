package com.kotlin.user.service

import rx.Observable

/**
 * Created by 江婷婷 on 2018/2/1.
 */
interface UserService {
    fun register(mobile: String, verifyCode: String, pwd: String) : Observable<Boolean>
}