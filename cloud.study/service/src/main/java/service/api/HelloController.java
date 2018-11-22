package service.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping(value="/")
public class HelloController {

	@Value("${hello}")
	private String hello;
	
	@GetMapping
	public String home() {
		return "home";
	}
	
	@GetMapping(value="/hello")
	public String hello() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hello;
	}
	
}
