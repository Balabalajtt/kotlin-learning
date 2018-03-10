package com.kotlin.user.data.protocol

/**
 * Created by 江婷婷 on 2018/2/2.
 */
data class RegisterReq(val mobile: String, val verifyCode: String, val pwd: String)