# repeat-submit

基于Spring Boot v2.x 的防抖机制插件

## 项目背景

基于RuoYi快速开发框架抽取出来的后端防抖业务，封装成jar包，达到快速使用的目的。

## 使用简介

第一步：将打好的jar包导入项目

第二步：增加配置

```yaml
repeatsubmit:
  # 开启防抖。默认true
  enable: true
  # 过期时间，单位秒。默认5
  expire-time: 5
```

第三步：使用注解@RepeatSubmit

```java
@RepeatSubmit
@PostMapping("/save")
public String save(User user) {
	dao.save(user);
    return "success";
}
```



