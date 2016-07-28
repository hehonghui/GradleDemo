# Gradle 插件开发
[参考文章](http://blog.csdn.net/sbsujjbcy/article/details/50782830)


## 在build.gradle添加如下脚本之后 groovy 文件夹才被识别


```
apply plugin: 'groovy'
apply plugin: 'maven'

dependencies {
    compile gradleApi()
    compile localGroovy()
}

repositories {
    mavenCentral()
}
```