package com.simple.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 模拟编译任务
 */
public class AppBuildTask extends DefaultTask {

    @TaskAction
    void output() {
        println "=======》编译参数输出: "
        println "build minSDK is ${project.buildParams.minSDK}"
        println "build applicationId is ${project.buildParams.applicationId}"
        println "build 包名 :  " +  project.buildParams.applicationId
        println "signConfig is ${project.buildParams.compileParams.signConfig}"
        println "minifyEnabled is ${project.buildParams.compileParams.minifyEnabled}"
    }
}