# Gradle 相关项目

* translateplugin 为gradle插件, 模拟参数传递等
* app 为使用translateplugin插件,且配置好checktyle的App, git commit之前会执行 checkstyle
* app 中使用 Roboletric 进行单元测试, 参考文章 [用Robolectric来做Android unit testing](https://segmentfault.com/a/1190000002904944)

> 使用 Roboletric做单元测试时测试代码在 src/test目录，而不是 src/androidTest目录. 第一次运行 测试用例时会下载相关依赖