# springcloud
spring cloud study &amp; demo

# 2018.11.22
版本：
	Spring Cloud ： Finchley.RELEASE ； SpringBoot： 2.1.0.RELEASE

1、eureka 注册中心 port：8080

2、config 配置中心 port：8089

3、admin 管理中心 port：9090

4、service 服务提供者 port：8081

	集成配置中心客户端、管理中心客户端，使用RabbitMQ支持配置中心配置文件自动刷新

5、client 服务消费者 port：8082

	开启熔断
   
6、hystrix 熔断监控 port：8088

7、gateway 网关 port：8086

	集成熔断，提供身份认证过滤器、跨域支持
   
# 遇到的问题

1、server.port = 0
   服务注册到eureka，使用配置中心的配置，配置server.port = 0 ，会出现读取了配置中心配置，但是注册不了服务的问题

2、使用刷新配置中心数据，需要在配置中心的客户端配置management.endpoints.web.exposure.include=refresh,health,info ， 把refresh暴露出来

3、gateway的版本使用Greenwich.M3，如果使用统一的Finchley.RELEASE，会报错：
   Consider revisiting the entries above or defining a bean of type 'org.springframework.web.reactive.socket.client.WebSocketClient' in your configuration.
