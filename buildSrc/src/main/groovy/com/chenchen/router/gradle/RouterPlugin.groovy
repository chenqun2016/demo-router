package com.chenchen.router.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class RouterPlugin implements Plugin<Project>{
    //实现apply方法，注入插件的逻辑，被应用是就会调用
    @Override
    void apply(Project project) {
        println("我是 RouterPlugin,apply from ${project.name}")
        //"router" 可以随便起
        project.getExtensions().create("router",RouterExtension)

        project.afterEvaluate {
            //这里才可以拿到 RouterExtension 的参数
            RouterExtension extension = project["router"]
            println("用户设置的WIKI路径为：${extension.wikiDir}")
        }
    }
}