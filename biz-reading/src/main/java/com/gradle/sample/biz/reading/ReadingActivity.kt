package com.gradle.sample.biz.reading

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.chenchen.router.annotations.Destination

@Destination(
    url = "router://reading",
    destination = "阅读页"
)
class ReadingActivity :Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)

        val stringExtra = intent.getStringExtra("name")
        val text = findViewById<TextView>(R.id.text)
        text.text = stringExtra
    }
}