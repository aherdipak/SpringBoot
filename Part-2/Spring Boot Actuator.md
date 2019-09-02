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



#### Example : `SpringBoot_Actuator` project directory
