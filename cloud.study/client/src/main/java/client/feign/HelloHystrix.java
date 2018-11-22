package client.feign;

import org.springframework.stereotype.Service;

@Service
public class HelloHystrix implements HelloFeign {

	@Override
	public String serviceHome() {
		return "HelloHystrix:home";
	}

	@Override
	public String serviceHello() {
		return "HelloHystrix:hello";
	}

}
