package com.simple.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project;

// 插件实现
public class ATranslatePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        // 参数名为buildParams
        project.extensions.create('buildParams', BuildParams)
        // 参数buildParams的子参数compileParams
        project.buildParams.extensions.create('compileParams', CompileParams)

        setupTasks(project)
    }

    private void setupTasks(Project project) {
        project.task('testTask') << {
            println "Hello gradle plugin"
        }

        project.task('customAppTask', type: AppBuildTask)
    }
}