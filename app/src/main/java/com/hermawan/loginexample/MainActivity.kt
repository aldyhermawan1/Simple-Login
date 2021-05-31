package com.hermawan.loginexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.hermawan.loginexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.edtUsername.text.toString()
            val password = binding.edtPassword.text.toString()
            mainViewModel.login(username, password)

            val tokenPreferences = TokenPreference(this)

            mainViewModel.loginData.observe(this, { login ->
                if (login.success == true) {
                    tokenPreferences.setToken(login.token!!)
                    val intent = Intent(this, MainActivity2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, login.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}