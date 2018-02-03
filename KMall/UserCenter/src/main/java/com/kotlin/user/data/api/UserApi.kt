package com.kotlin.user.data.api

import com.kotlin.baselibrary.data.protocol.BaseResp
import com.kotlin.user.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by 江婷婷 on 2018/2/2.
 */
interface UserApi {
    @POST("/s?wd=今日新鲜事&tn=SE_Pclogo_6ysd4c7a&sa=ire_dl_gh_logo&rsv_dl=igh_logo_pc")
    fun register(@Body req: RegisterReq) : Observable<BaseResp<String>>
}