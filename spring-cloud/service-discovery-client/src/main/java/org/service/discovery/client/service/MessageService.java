package org.service.discovery.client.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class MessageService {

	@Value("${service.instance.name}")
	private String instance;
	
	@RequestMapping("/")
	public String message() {
		
		return "hello from : "+instance;
	}
}
