package com.syedsaifhossain.restfulapidemo

import retrofit2.Call
import retrofit2.http.GET
interface RetrofitHelper {

    @GET("users")
    fun getProduct(): Call<List<UsersItem>>
}