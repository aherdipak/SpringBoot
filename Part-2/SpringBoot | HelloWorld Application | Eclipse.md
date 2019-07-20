## Spring Boot (Web Application creation using eclipse IDE)

Step by step description to create web application using spring boot

Step 1. Create new project, select checkbox of (skip archetype selection).

![Screenshot 2019-07-15 at 11 31 01 PM](https://user-images.githubusercontent.com/35020560/61240038-e6f31c00-a75d-11e9-9516-4bf53c4a8794.png)


Step 2. create class called as `HelloSpringBootApp`

![Screenshot 2019-07-15 at 11 34 44 PM](https://user-images.githubusercontent.com/35020560/61240130-1f92f580-a75e-11e9-9579-a83e5023c18d.png)


```
package com.dac.app;

public class HelloSpringBootApp {
	
}	

```

Step 3. Open `pom.xml` and add required dependencies.

```
<project xmlns="http://maven.apache.org/POM/4.0.0" 
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.dac.app</groupId>
  <artifactId>HelloWorldSpringBoot</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  <!-- JAVA VERSION -->
  <properties>
  	<java.version>1.8</java.version>
  </properties>
  
  <!-- SPRING BOOT VERSION -->
  <parent>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-parent</artifactId>
  	<version>1.5.4.RELEASE</version>
  </parent>
  
  <dependencies>
  <!-- spring boot starter jar -->
  	<dependency>
  		<groupId>org.springframework.boot</groupId>
  		<artifactId>spring-boot-starter-web</artifactId>
  	</dependency>
  </dependencies>
</project>
```

Step 4. Add `@SpringBootApplication` annotaion on top of the spring boot starter class.

```
package com.dac.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringBootApp {
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApp.class, args);
	}
}	

```

Step 5. create a rest controller with the name of `HelloWorldRestController`

```
package com.dac.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

	@GetMapping("/")
	public String hello() {
		return "Hello World..!!";
	}

}

```

Step 6. Run `HelloSpringBootApp` class as java application, go to browser and type `http://localhost:8080/` in url.

![Screenshot 2019-07-15 at 11 48 48 PM](https://user-images.githubusercontent.com/35020560/61240459-e3ac6000-a75e-11e9-98fa-32c0804fdd8b.png)


#### OUTPUT:

![Screenshot 2019-07-15 at 11 50 33 PM](https://user-images.githubusercontent.com/35020560/61240485-f32ba900-a75e-11e9-9c97-aab166658d41.png)


#### How to change default port of tomcat?

src/main/resource --> create file `application.properties`

```
server.port = 9090

```

#### Example : `HelloWorldSpringBoot` project directory
