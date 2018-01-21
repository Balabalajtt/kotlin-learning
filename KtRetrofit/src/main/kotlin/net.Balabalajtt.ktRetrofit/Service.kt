package net.Balabalajtt.ktRetrofit

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by 江婷婷 on 2018/1/21.
 */

interface GithubService {
    @GET("/users/Balabalajtt/following")
    fun getStartGazers(): Call<List<User>>
}

object Service{
    val gitHubService:GithubService by lazy {
        Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build().create(GithubService::class.java)
    }
}

fun main(args: Array<String>) {
    Service.gitHubService.getStartGazers().execute().body()?.map(::println)
}