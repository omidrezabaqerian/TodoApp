package com.omidrezabagherian.todoapplication.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.omidrezabagherian.todoapplication.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashBinding = ActivitySplashBinding.inflate(layoutInflater)

        Handler(mainLooper).postDelayed({
            val goToMain = Intent(this, MainActivity::class.java)
            startActivity(goToMain)
            finish()
        }, 5000)

        setContentView(splashBinding.root)
    }
}