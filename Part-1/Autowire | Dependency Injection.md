## Spring Boot (Autowire | Dependency Injection)

![image](https://user-images.githubusercontent.com/35020560/60381979-f560e880-9a79-11e9-9673-9cbe3063960c.png)


To understand Autowire & Dependency Injection concept I am going to create one student class and let's try to create its object.

```
package com.example.demo;

public class Student {

	private int studentId;
	private String studentName;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void show() {
		System.out.println("in Show...!!");
	}
}

--------------------------------------------------

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("welcome in Boot....!!");
	}
 
} 

```
Here in main method We are calling `Spring Application. run (DemoApplication. class, args);` method (Static helper that can be used to run a SpringApplication from the specified source using default settings.) this method returns `ConfigurableApplicationContext`.

```

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		Student std = ctx.getBean(Student.class);
		std.show();

		System.out.println("welcome in Boot....!!");
	}

}

```


##### Output:

```
Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.demo.Student' available
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:346)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:337)
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1123)
	at com.example.demo.DemoApplication.main(DemoApplication.java:15)

```
`Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.demo.Student' available` means we don't have this object.
###### But Why? What is happing behind the scene? what is `ConfigurableApplicationContext ctx = Spring Application. run (DemoApplication. class, args);` this method all about? So to solve this problem we will understand what is happing here?

Spring provides you a spring container. The way we have `JVM`. What this container will have? This will have different objects but which objects? So the object which spring specifies those objects, the object which spring specifies those are (in fact the object which we create here) those are called as spring beans.

So how do we create a spring bean? And when they get created? Basically we have two scopes when we create a spring bean first is singleton scope and the second one is prototype scope in fact, in the spring we have so many scopes available like request. session and much more. But those things we use in web applications in core application, we use these two only (prototype & singleton).

How do we specify singleton & how do we specify, prototype & what does it exactly means? If we see above Student class code this Student class in is not a spring bean here, and even it is a spring bean when it gets created?

The container of spring bean or the container of spring gets created for this line `ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);`

The moment you say run. It returns you the context, this is where it initializes your container and in this container it will try to create all the objects But which objects?

Let's say if I have 10 classes or if we have 15 classes Will you create objects of all the classes? 
Not exactly, You have to specify as a developer which object you want?
How do we specify to spring framework hey, I don't want all the objects I want the only object of Student class?

The way you do that is by making it by writing `@Componant` by doing this you are specifying. Hey spring framework this is a class of which I want an object. Now by default the moment you say run on this application will create a container for you.
And with that it will create one object of Stduent here. And the student object of type Student class. It will be available in spring container.

The moment you say `ctx.getBean(Student.Class);`your spring provides a bean, whatever type you has specified in method parameter.
Spring framework checks we do have a bean there if they do have it? It will get connected automatically that means spring framework injecting this object (Student) in your application So this object created by spring framework or spring container.
```
@Component
public class Student {

	private int studentId;
	private String studentName;
	....
	....
}

```
![image](https://user-images.githubusercontent.com/35020560/60382209-97ce9b00-9a7d-11e9-8477-4a8f11633768.png)

What if I say getBean() once more will it create two objects? And how do we verify how many objects we are getting?
To identify that I will create constructor, see below

```
@Component
public class Student {

	private int studentId;
	private String studentName;
	
	public Student() {
		super();
		System.out.println("Object Created...!!!");
	 }
	...
	...
	...

```
So how many times it should print `Object Created...!!!` Only once because we are using this object only once.
Let's run this code...

##### Output:
```
2019-06-29 13:05:42.454  INFO 1007 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1007 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 13:05:42.458  INFO 1007 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
Object Created...!!!
2019-06-29 13:05:42.931  INFO 1007 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.755 seconds (JVM running for 1.51)
in Show...!!
welcome in Boot....!!
```

What if I don't want to try to fetch this? 
Comment this section and run it.

```
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

//		Student std = ctx.getBean(Student.class);
//		std.show();

		System.out.println("welcome in Boot....!!");
	}
} 

```
##### Output:

```
2019-06-29 13:05:42.454  INFO 1007 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1007 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 13:05:42.458  INFO 1007 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
Object Created...!!!
2019-06-29 13:05:42.931  INFO 1007 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.755 seconds (JVM running for 1.51)
welcome in Boot....!!

```

Even if you're not saying getBean() you got the object because spring framework says even if you don't want object we will give it to you because by default spring uses a concept of the singleton design pattern Which means it will give the object pre hand, I mean you don't have to wait for the object creation the moment you start the application it will give you the object.

Now if I ask getBean() two times?

Now what you think will it print `object created..!!` Once or two times?

##### Output:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-06-29 13:13:03.424  INFO 1016 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1016 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 13:13:03.427  INFO 1016 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
Object Created...!!!
2019-06-29 13:13:03.914  INFO 1016 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.763 seconds (JVM running for 1.455)
in Show...!!
in Show...!!
welcome in Boot....!!

```

We can see it it crating object only once because in total it will create only object because by default spring framework uses the concept of the singleton design pattern In singleton we get only one instance.

How if I say prototype? 
For that we have to use another annotation called as @scope.

So it will be using prototype. Now so it will be using prototype now, which means it Not create an instance by default for you.

When you say getBean () at that point it will create objects for you, So in total you will be getting two objects now.
Let's run this code.
##### Output:

 ```
   .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-06-29 13:22:38.386  INFO 1024 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1024 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 13:22:38.389  INFO 1024 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-29 13:22:38.833  INFO 1024 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.733 seconds (JVM running for 1.568)
Object Created...!!!
in Show...!!
Object Created...!!!
in Show...!!
welcome in Boot....!!

 ```
Here we can see `Objects created....!` `object created....!` two times because we are getting two objects now every time you say getBean() it will create a new object for you.

What if I don't even call this once I will comment getBean() part.


```
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

//		Student std1 = ctx.getBean(Student.class);
//		std1.show();
//		
//		Student std2 = ctx.getBean(Student.class);
//		std2.show();

		System.out.println("welcome in Boot....!!");
	}

} 
```
Now what do you think will it print one, two or zero times?

Since we are using prototype which means the application will not be going to create objects ready for you. So this will not be there if you are using prototype. 
Let's check it:

##### Output:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-06-29 13:32:12.865  INFO 1031 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1031 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 13:32:12.868  INFO 1031 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
2019-06-29 13:32:13.333  INFO 1031 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.765 seconds (JVM running for 1.553)
welcome in Boot....!!

```

It will create an object only when you say getBean()

##### Autowired:


```
package com.example.demo;

public class Computer {

	private int cId;
	private String brand;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "cId=" + cId + ", brand=" + brand;
	}

	public void execute() {
		System.out.println("Executing...!");
	}

}

---------------------------------------------

package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Student {

	private int studentId;
	private String studentName;
	private Computer computer;

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void show() {
		System.out.println("in Show...!!");
		computer.execute();
	}

	public Student() {
		System.out.println("Object Created...!!!");
	}

}

---------------------------------------------

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);

		Student std1 = ctx.getBean(Student.class);
		std1.show();

		System.out.println("welcome in Boot....!!");
	}
 
} 


```
Now what you think will it work? Because we have a computer class and we got computer class in Student class So Student class is dependent on Computer class, now what will happen?


##### Output:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-06-29 13:45:38.925  INFO 1042 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1042 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 13:45:38.928  INFO 1042 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
Object Created...!!!
2019-06-29 13:45:39.366  INFO 1042 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.723 seconds (JVM running for 1.539)
in Show...!!
Exception in thread "main" java.lang.NullPointerException
	at com.example.demo.Student.show(Student.java:40)
	at com.example.demo.DemoApplication.main(DemoApplication.java:16)
```

We can see we got a NullPointerException but why? 
Because if we are seen in Student class We are saying a `computer.executes();` Here the problem is computer is not instantialed.
Because before using object we have to say `new Computer();` but again we are using spring framework why I should say `new Comuter();`.
Here your spring framework not created a computer class object because we have not tell spring to create object of a computer . So to create computer class object use `@Componant` on top of the Computer class.

```
@Component
public class Computer {

	private int cId;
	private String brand;
	...
	...


}
```

So now if we run this application in your container you we will get one more object of the type of the computer.

Now all this work because we get both the object right.


##### Output:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-06-29 13:58:01.329  INFO 1050 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1050 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 13:58:01.333  INFO 1050 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
Computer object Created...!!
Object Created...!!!
2019-06-29 13:58:01.772  INFO 1050 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.723 seconds (JVM running for 1.528)
in Show...!!
Exception in thread "main" java.lang.NullPointerException
	at com.example.demo.Student.show(Student.java:40)
	at com.example.demo.DemoApplication.main(DemoApplication.java:16)

```

Again, we got the same output. But we got the object. Still, there is one problem here Student object is dependant on Computer object So how will Student object will know that there is a Computer object available And how do we search it?
So that we have to connect this two we have to say hey Student There is some Computer object available search for it.
How do we mention that how do we ask a Student to search for it automatically? So we can do this by using concept of `Autowired`.


```

@Component
public class Student {

	private int studentId;
	private String studentName;
	@Autowired
	private Computer computer;
	...
	...
}
```

The moment you say @Autowired it will try to search for the object in the spring container now it will work.

##### Output:
```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-06-29 14:06:10.146  INFO 1055 --- [           main] com.example.demo.DemoApplication         : Starting DemoApplication on Dipaks-MacBook-Air.local with PID 1055 (/DEEPAK/JAVA_CODING/Spring_Boot/demo/target/classes started by dipakaher in /DEEPAK/JAVA_CODING/Spring_Boot/demo)
2019-06-29 14:06:10.149  INFO 1055 --- [           main] com.example.demo.DemoApplication         : No active profile set, falling back to default profiles: default
Computer object Created...!!
Object Created...!!!
2019-06-29 14:06:10.590  INFO 1055 --- [           main] com.example.demo.DemoApplication         : Started DemoApplication in 0.749 seconds (JVM running for 1.533)
in Show...!!
Executing...!
welcome in Boot....!!

```
By default autowired search for a Type not for the name.

What if we want to search by name?


```

@Component
public class Student {

	private int studentId;
	private String studentName;
	@Autowired
	@Qualifier("comp1")
	private Computer computer;
	...
	...
}
```

