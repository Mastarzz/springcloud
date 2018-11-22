package client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value="service",fallback=HelloHystrix.class)
public interface HelloFeign {
	@RequestMapping("/")
	String serviceHome();
	@RequestMapping("/hello")
	String serviceHello();
}
