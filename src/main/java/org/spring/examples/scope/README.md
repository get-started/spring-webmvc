# Spring Scoped Bean

## 注意事项
- 使用**@Scope("request")**来定义request Bean；
- 当**Controller**中使用了request Bean时,**Controller**也应该使用**@Scope("request")**来标注该Controller,这样Spring会为每个请求创建一个**User**实例；
- 如果**Controller**未使用**@Scope("request")**标注，每次请求时Spring将共享一个**User**实例，然后使用Proxy方式注入HttpServletRequest对象，如果是这样的话**User**不是线程安全的；
- 使用request Bean必须在web.xml根据需要定义**RequestContextListener/RequestContextFilter**
```xml
    <listener>
        <listener-class>org.springframework.web.context.request.RequestContextListener</listener-class>
    </listener>
```