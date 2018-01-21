package net.Balabalajtt.ktRetrofit

/**
 * Created by 江婷婷 on 2018/1/21.
 */
data class User(val login:String, val id:Long, val avatar_url:String) {
    override fun toString(): String {
        return "名字:$login  id:$id  头像:$avatar_url"
    }
}