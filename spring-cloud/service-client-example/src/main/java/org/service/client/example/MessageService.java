package org.service.client.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;

@RestController
@Component
public class MessageService {

	/*@Autowired
	DiscoveryClient discoveryClient;*/
	@Autowired
	EurekaClient eurekaClient;
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	InstanceInfo getInstanceInfo() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("Discovery-Service-Client", false);
		return instance;
	}
	
	public String getBaseUrl() {
		InstanceInfo info = getInstanceInfo();
		System.out.println("port is :" + info.getPort() + "  host  :" + info.getHostName());
		return info.getHomePageUrl();
	}

	/*List<InstanceInfo> getInstances() {
		return discoveryClient.getInstancesById("Discovery-Service-Client");

	}*/

	/*public String getBaseUri() {
		List<InstanceInfo> infos = getInstances();
		InstanceInfo info = infos.get(0);
		System.out.println("port is :" + info.getPort() + "  host  :" + info.getHostName());
		return info.getHomePageUrl();
	}*/

	@RequestMapping("/")
	public String callService() {
		RestTemplate template = restTemplateBuilder.build();
		String url = getBaseUrl();
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);

		return response.getBody();
	}
}
