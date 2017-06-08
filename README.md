## 烟草网上销售系统

#### 要求

- [JDK >= 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven >= 3.5.0](https://maven.apache.org/download.cgi)
- [MySQL](https://dev.mysql.com/downloads/mysql)

#### 编译说明

- 执行mvn clean package
- 安装包：target/**tobacco-sales-online-1.0-SNAPSHOT.jar**
- [表初始脚本](https://github.com/liqingfei/tobacco-sales-online/tree/master/src/main/resources/db)

#### 运行命令

```
java -jar tobacco-sales-online-1.0-SNAPSHOT.jar
```
- [安装包下载](https://github.com/liqingfei/tobacco-sales-online/releases)
- 服务监听 0.0.0.0:8080