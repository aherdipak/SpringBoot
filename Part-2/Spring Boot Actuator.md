## Spring Boot Actuator basics | Production Monitoring and Management


* Spring Boot Actuator Documentation 
  - https://docs.spring.io/spring-boot/docs/current/actuator-api/html/
  - https://www.callicoder.com/spring-boot-actuator/
  
* Spring Boot Actuator Endpoints 
  - https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html


###  Overview

- Spring Boot Actuator basics

![image](https://user-images.githubusercontent.com/35020560/63647958-18d8a480-c746-11e9-8118-c2ca59d0e143.png)

![image](https://user-images.githubusercontent.com/35020560/63647969-43c2f880-c746-11e9-8e54-1dbb379de47c.png)


### Requirement

1) Actuator run on some other port

#### / application.properties
```
management.server.port=9999 

```
![image](https://user-images.githubusercontent.com/35020560/63648075-ff385c80-c747-11e9-813b-e158644ec174.png)



2) To change base-path `/actuator` to `/manage`

#### / application.properties
```
# To change base-path /actuator to /manage
management.endpoints.web.base-path=/manage

```
![image](https://user-images.githubusercontent.com/35020560/64125090-71531600-cdc6-11e9-8ca9-20bbfd454592.png)

3) To enabled endpoint

#### / application.properties
```

# To enabled endpoint
management.endpoint.shutdown.enabled=true
management.endpoint.env.enabled=true

# Use "*" to expose all endpoints, or a comma-separated list to expose selected ones
#management.endpoints.web.exposure.include=health,info,env
management.endpoints.web.exposure.include=*

```

4) Displaying detailed health information

#### / application.properties
```
# HEALTH ENDPOINT
management.endpoint.health.show-details=always
```
![image](https://user-images.githubusercontent.com/35020560/64125372-56cd6c80-cdc7-11e9-9f7a-26b66e235536.png)

5) Creating a Custom Health Indicator

```

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
```

![image](https://user-images.githubusercontent.com/35020560/64125372-56cd6c80-cdc7-11e9-9f7a-26b66e235536.png)

#### Example : `SpringBoot_Actuator` project directory
