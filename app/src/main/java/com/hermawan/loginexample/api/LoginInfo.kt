package com.hermawan.loginexample.api

import com.google.gson.annotations.SerializedName

data class LoginInfo(

	@field:SerializedName("username")
	val username: String? = null,

	@field:SerializedName("password")
	val password: String? = null

)
