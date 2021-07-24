1. security 本质上是一个过滤器链
2. 重要的过滤器
    a. FilterSecurityInterceptor 方法级别的权限过滤器，位于最底部
    b. 
    c. UsernamePasswordAuthenticationFilter 用户名密码
3. 过滤器是如何加载的？
    
4. 实现UserDetailsService， 重写自己的用户校验逻辑

5. PasswordEncoder 密码加密的接口

6. 设置用户名密码
    a. 用配置文件
    b. 用配置类
    c. 便写自定义实现类