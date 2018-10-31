package org.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClientApp 
{
	@Autowired
	private ConfigAppConfiguration properties;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
    public static void main( String[] args )
    {
        SpringApplication.run(ConfigClientApp.class, args);
    }
    @RequestMapping
	public String printConfig() {

		StringBuilder sp=new StringBuilder();
		sp.append(properties.getProperty());
		sp.append(" || ");
		sp.append(someOtherProperty);
		
		return sp.toString();
	}

    
}
