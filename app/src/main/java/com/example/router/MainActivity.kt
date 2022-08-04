package com.example.router

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import com.chenchen.router.annotations.Destination
import com.example.router.runtime.Router

@Destination(
    url = "router://page-home",
    destination = "应用首页"
)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text).setOnClickListener {
            Router.go(this@MainActivity,"router://reading?name=你好啊 啊")
        }
    }
}