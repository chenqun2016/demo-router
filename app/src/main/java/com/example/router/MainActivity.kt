package com.example.router

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chenchen.router.annotations.Destination

@Destination(
    url = "router://page-home",
    destination = "应用首页"
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}