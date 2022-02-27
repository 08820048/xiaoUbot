# 骁幽Bot

这是[simple-robot](https://github.com/ForteScarlet/simpler-robot) 框架使用[mirai组件](https://github.com/ForteScarlet/simpler-robot/tree/dev/component/component-mirai) 对接[Mirai](https://github.com/mamoe/mirai) 并整合为 Spring Boot 的QQ群机发题器人开源项目。

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

### 阅读
- [listener](src/main/java/simbot/xiaoU/listener) 包下为一些监听函数示例。阅读它们的注释，并可以试着修改它们。

### 运行
执行[SimbotExampleApplication](src/main/java/simbot/xiaoU/SimbotExampleApplication.java) 中的main方法。

### 验证
如果你是第一次使用此框架，且出现了诸如需要“滑动验证”等相关错误，你可以尝试先使用一次 [simbot-mirai-login-solver-selenium-helperPack](https://github.com/simple-robot/simbot-mirai-login-solver-selenium-helperPack) 来使腾讯记住你的设备信息。

以及，记得关闭账号中与“设备锁”、“安全保护”等相关内容。

### 测试
 > 测试QQ群：917125728

