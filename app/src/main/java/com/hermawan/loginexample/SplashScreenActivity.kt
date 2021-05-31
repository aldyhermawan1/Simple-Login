package com.hermawan.loginexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.hermawan.loginexample.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val tokenPreference = TokenPreference(this)

        handler = Handler(mainLooper)
        handler.postDelayed({
            if (tokenPreference.getToken().isNullOrBlank()){
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity2::class.java))
            }
            finish()
        }, 3000)
    }
}