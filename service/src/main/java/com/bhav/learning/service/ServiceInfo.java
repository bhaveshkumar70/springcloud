package com.bhav.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class ServiceInfo {
	
	@Autowired
	private EurekaClient discoveryClient;
	
	
	public String getMessage() {
		return null;
		
	}
	
	@RequestMapping("/")
	public String sayHello() {
		
		System.out.println("Hi there ");
		return "Hello from Spring boot";
	}

	public String serviceUrl() {
	    InstanceInfo instance = discoveryClient.getNextServerFromEureka("EmployeeEurekaServer", false);
	    return instance.getHomePageUrl();
	}

}
