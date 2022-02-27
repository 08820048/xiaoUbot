# 骁幽Bot
> 需求源于自己的一个推理爱好者Q群,没有时间发推理题目的情况下，在某宝买了很多机器人，发现娱乐功能一堆，却没有发题这一核心(不能自定义)。于是花了两天时间自己现学现卖随便写了一个，核心功能基本实现，题库需要自己录入数据库(目前题库题量很少)。
> 不管怎么说，起码暂时解放了双手，关于其他功能的开发与题库数据的录入工作有时间就继续！
## 技术说明
  - 后端:SpringBoot
  - 数据库:MySQL+MyBatis
  - 框架:simple-robot
## 需要做的
### fork/clone
fork或者clone此项目到你的本地，并使用IDE工具打开并构建它。

### 修改配置文件
打开文件 [application.yml](src/main/resources/application.yml) 并修改其中的 `simbot.core.bots` 项为你测试用的QQ账号，例如：
```yaml
simbot: 
  core:
    bots: 123456789:password
```

### 保证安静
将你的bot放在一些测试用的群而不是一些大型群。


### 运行
执行[SimbotExampleApplication](src/main/java/simbot/xiaoU/SimbotExampleApplication.java) 中的main方法。

### 验证
如果你是第一次使用此框架，且出现了诸如需要“滑动验证”等相关错误，你可以尝试先使用一次 [simbot-mirai-login-solver-selenium-helperPack](https://github.com/simple-robot/simbot-mirai-login-solver-selenium-helperPack) 来使腾讯记住你的设备信息。

以及，记得关闭账号中与“设备锁”、“安全保护”等相关内容。

### 测试
 > 测试QQ群：917125728。

### 致谢
- [simple-robot](https://github.com/ForteScarlet/simpler-robot) 

<p align="center">
    <a href="#投稿"><img src="https://img.shields.io/badge/开源-精神-blue.svg" alt="投稿"></a>
  <a href="#公众号"><img src="https://img.shields.io/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-代码不良人-lightgrey.svg" alt="公众号"></a>
  <a href="#公众号"><img src="https://img.shields.io/badge/语言-Java-important.svg" alt="公众号"></a>
  <a href="#投稿"><img src="https://img.shields.io/badge/support-持续更新-green.svg" alt="投稿"></a>
  <a href="#投稿"><img src="https://img.shields.io/badge/框架-SpringBoot-orange.svg" alt="投稿"></a>
    <a href="#投稿"><img src="https://img.shields.io/badge/MyBatis-orange.svg" alt="投稿"></a>
  <a href="#投稿"><img src="https://img.shields.io/badge/QQ群-机器人-yellow.svg" alt="投稿"></a>
  <a href="#投稿"><img src="https://img.shields.io/badge/数据库-MySql-red.svg" alt="投稿"></a>
</p>
