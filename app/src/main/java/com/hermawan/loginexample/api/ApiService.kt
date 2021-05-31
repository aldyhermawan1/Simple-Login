package com.hermawan.loginexample.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("kustomer/login")
    fun login(@Body loginInfo: LoginInfo): Call<LoginResponse>
}