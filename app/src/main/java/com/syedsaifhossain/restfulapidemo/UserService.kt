package com.syedsaifhossain.restfulapidemo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


    object ProductService {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitHelper::class.java)

    }