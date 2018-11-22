package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import gateway.filter.CustomFilter;

@SpringBootApplication
public class GatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/test/prefix/**")
				.filters(f -> f.stripPrefix(2).filter(new CustomFilter()).addResponseHeader("X-Response-test", "test"))
				.uri("lb://CLIENT").order(0).id("CLIENT")).build();
	}
}
