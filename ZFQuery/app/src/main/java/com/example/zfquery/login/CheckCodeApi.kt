package com.example.zfquery.login

import com.example.zfquery.base.BaseConstant.Companion.LOGIN_POST_URL
import com.example.zfquery.base.BaseResp
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import rx.Observable

/**
 * Created by 江婷婷 on 2018/2/4.
 */
interface LoginApi {
    @FormUrlEncoded
    @POST(LOGIN_POST_URL)
    fun login(@FieldMap map: Map<String, String>) : Observable<BaseResp<String>>

}