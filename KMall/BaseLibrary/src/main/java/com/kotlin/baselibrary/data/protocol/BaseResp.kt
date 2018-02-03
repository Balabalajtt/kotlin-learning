package com.kotlin.baselibrary.data.protocol

/**
 * Created by 江婷婷 on 2018/2/2.
 */
class BaseResp<out T>(val status: Int, val message: String, val data: T)