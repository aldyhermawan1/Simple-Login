package com.hermawan.loginexample

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hermawan.loginexample.api.ApiConfig
import com.hermawan.loginexample.api.LoginInfo
import com.hermawan.loginexample.api.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val _loginData = MutableLiveData<LoginResponse>()
    val loginData: LiveData<LoginResponse> = _loginData

    fun login(username: String, password: String){
        val body = LoginInfo(username, password)
        val client = ApiConfig.getApiService().login(body)
        client.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    _loginData.value = response.body()
                } else {
                    Log.e(MainViewModel::class.java.simpleName, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e(MainViewModel::class.java.simpleName, "onFailure: ${t.message.toString()}")
            }

        })
    }
}