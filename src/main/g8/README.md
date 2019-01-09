## 使用说明
~~~
```sbt compile``` 解释:编译
```sbt publish-local``` 解释:发布到本地的仓库
```sbt assembly``` 解释:在工程的根目录下生成一个bin目录，并将工程打包 '$appname$-jar' 后放在该处。
```sbt assemblyPackageDependency``` 解释:在工程的根目录下生成一个bin目录，并将工程所有依赖的lib打成统一个包 '$appname$-depn-jar' 后放在该处。
~~~

## 样例
~~~
+-- build.sbt
+-- module1
|   +-- src
|     +-- main
|       +-- scala
|         +-- com
|           +-- example
|             +-- myproject
|               +-- module1
|                 +-- Trait1.scala
+-- module2
|   +-- src
|     +-- main
|       +-- scala
|         +-- com
|           +-- example
|             +-- myproject
|               +-- module1
|                 +-- Trait2.scala
+-- app
|   +-- src
|     +-- main
|       +-- scala
|         +-- com
|           +-- example
|             +-- myproject
|               +-- app
|                 +-- HelloWorld.scala
+-- project
|  +-- Dependencies.scala
|  +-- Settings.scala
|  +-- build.properties
|  +-- plugins.sbt
~~~
