package com.example.router

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chenchen.router.annotations.Destination

@Destination(
    url = "router://page-login",
    destination = "登录页面"
)
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}