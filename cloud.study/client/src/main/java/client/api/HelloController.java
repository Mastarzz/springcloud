package client.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import client.feign.HelloFeign;

@RestController
public class HelloController {
	
	@Autowired
	private HelloFeign helloFeign;
	
	@RequestMapping(value="/")
	public @ResponseBody Object home() {
		return "Client";
	}
	
	@RequestMapping(value="/service")
	public @ResponseBody Object getService() {
		return helloFeign.serviceHome();
	}
	
	@RequestMapping(value="/service/hello")
	public @ResponseBody Object getServiceHello() {
		return helloFeign.serviceHello();
	}

}
