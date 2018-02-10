package com.example.zfquery.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.zfquery.R
import com.example.zfquery.base.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.model.GlideUrl
import com.example.zfquery.base.BaseConstant.CHECK_CODE_URL
import com.example.zfquery.base.BaseConstant.SERVER_ADDRESS
import com.example.zfquery.base.execute
import com.example.zfquery.base.BaseSubscriber
import okhttp3.ResponseBody
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    fun showToast() {
        toast("111111111111111111")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCheckCode()

        mLoginBtn.onClick {
            login(mUserNameEd.text.toString(), mPwdEd.text.toString(), mCheckCodeEd.text.toString())
        }

        mCheckCodeImg.onClick {
            getCheckCode()
        }

    }

    private fun getCheckCode() {
        Glide.with(this)
                .load(GlideUrl(SERVER_ADDRESS + CHECK_CODE_URL, LazyHeaders.Builder()
                        .addHeader("Cookie", "ASP.NET_SessionId=z03gtbnnl2pzaf55bj252f45").build()))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(mCheckCodeImg)

    }

    private fun login(id: String, pwd: String, checkCode: String) {

        val map = mapOf("__VIEWSTATE" to "dDwxNTMxMDk5Mzc0Ozs+lYSKnsl/mKGQ7CKkWFJpv0btUa8=",
                "txtUserName" to id,
                "Textbox1" to "",
                "TextBox2" to pwd,
                "txtSecretCode" to checkCode,
                "RadioButtonList1" to "%D1%A7%C9%FA",
                "Button1" to "",
                "lbLanguage" to "",
                "hidPdrs" to "",
                "hidsc" to "")

        RetrofitFactory.instance.create(LoginApi::class.java)
                .login(map)
                .execute(object : BaseSubscriber<ResponseBody>() {
                    override fun onNext(t: ResponseBody) {
                        showToast()
                        Log.d("login", t.string())
                    }
                })
    }
}