package com.chenchen.router.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class RouterPlugin implements Plugin<Project>{
    //实现apply方法，注入插件的逻辑
    @Override
    void apply(Project project) {
        println("我是 RouterPlugin,apply from ${project.name}")
    }
}