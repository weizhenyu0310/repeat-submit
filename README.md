# repeat-submit

基于Spring Boot v2.x 的防止重复提交表单（防抖机制）插件

## 项目背景

基于RuoYi快速开发框架抽取出来的后端防抖业务，封装成jar包，达到快速使用的目的。

## 快速开始

### 第一步：将打好的jar包导入项目

### 第二步：增加配置

```yaml
repeatsubmit:
  # 开启防抖。默认true
  enable: true
  # 过期时间，单位秒。默认5
  expire-time: 5
```

### 第三步：使用注解@RepeatSubmit

```java
@RepeatSubmit
@PostMapping("/save")
public String save(User user) {
	dao.save(user);
    return "success";
}
```

## 扩展

### 自定义response

插件默认返回response数据如下：

```
response code : 400
response body : 您提交了重复的数据
```

如果需要返回自定义数据，可以在异常处理器中捕获RepeatSubmitException，返回自定义response

```java
/** 
 * 全局异常处理器
 */
@ControllerAdvice
public class GlableExceptionHandler {
	
    /*
     * 捕获RepeatSubmitException，返回自定义response
     */
	@ExceptionHandler(value = RepeatSubmitException.class)
	public ? handleRepeatSubmitException(RepeatSubmitException e){
		return ?;
	}
}
```

