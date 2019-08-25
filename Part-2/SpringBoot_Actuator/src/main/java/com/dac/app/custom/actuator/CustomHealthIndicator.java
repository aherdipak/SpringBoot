package com.dac.app.custom.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator{

	  private final String message_key = "Custom Service";

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
        
        if (isRunningService()) {
             builder.up().withDetail(message_key, "Available")
             			 .withDetail("message", "I am from custom actuator");
        }else {
        	 builder.down().withDetail(message_key, "Not Available")
        	 			   .withDetail("message", "I am from custom actuator");
        }
		
	}
	
	
    private Boolean isRunningService() {
        Boolean isRunning = true;
        // Logic 
        return isRunning;
    }

}
