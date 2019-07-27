package com.example.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfiguration() {
		return new LimitsConfiguration(config.getMax(),config.getMin());
	}
	
	@GetMapping("/fault-tolerence-example")
	@HystrixCommand(fallbackMethod = "retrieveLimitsFromConfiguration")
	public LimitsConfiguration retrieveConfiguration() {
		throw new RuntimeException("Not working!");
	}
}
