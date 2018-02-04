package com.example.zfquery.base

/**
 * Created by 江婷婷 on 2018/2/4.
 */
class BaseResp<out T>(val status: Int, val message: String, val data: T)