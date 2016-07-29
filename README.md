# Gradle 相关项目

* translateplugin 为gradle插件, 模拟参数传递等
* app 为使用translateplugin插件,且配置好checktyle的App, git commit之前会执行 checkstyle
* app 中使用 Roboletric 进行单元测试, 参考文章 [用Robolectric来做Android unit testing](https://segmentfault.com/a/1190000002904944)

> 使用 Roboletric做单元测试时测试代码在 src/test目录，而不是 src/androidTest目录. 第一次运行 测试用例时会下载相关依赖


## 保证项目的代码质量三部曲

1. 代码规范
2. 单元测试 ( 少量的ui测试 ), 单元测试主要测试热点业务逻辑以及数据相关的接口
3. Code Review 机制, (代码的逻辑、设计、重构方法等)


> 1. git commit 阶段执行 checkstyle
> 2. git push 阶段执行 ut
> 3. pull request时执行code review

## 参考文章

[解读Android官方MVP项目单元测试](http://www.jianshu.com/p/cf446be43ae8)
[Google Application Architecture](https://github.com/googlesamples/android-architecture/tree/todo-mvp)