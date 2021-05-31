package com.hermawan.loginexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hermawan.loginexample.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val tokenPreferences = TokenPreference(this)

        binding.tvToken.text = tokenPreferences.getToken()

        binding.btnLogout.setOnClickListener {
            tokenPreferences.setToken("")
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}