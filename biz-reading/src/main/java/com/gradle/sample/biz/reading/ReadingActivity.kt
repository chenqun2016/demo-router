package com.gradle.sample.biz.reading

import android.app.Activity
import com.chenchen.router.annotations.Destination

@Destination(
    url = "router://reading",
    destination = "阅读页"
)
class ReadingActivity :Activity(){

}