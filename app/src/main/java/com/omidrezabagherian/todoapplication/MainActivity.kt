package com.omidrezabagherian.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.omidrezabagherian.todoapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
    }
}