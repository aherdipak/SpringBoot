## Spring Boot (Web Application creation)

Step by step description to create web application using spring boot

1. Create new project

![Screenshot 2019-07-02 at 11 09 21 PM](https://user-images.githubusercontent.com/35020560/60537221-a8a13a00-9d25-11e9-85b0-babfd32df8d6.png)


2. Give project & pakage name 

![Screenshot 2019-07-02 at 11 10 48 PM](https://user-images.githubusercontent.com/35020560/60537303-d7b7ab80-9d25-11e9-8a92-5db41869d870.png)

3. Select project dependancies of web application
    mark on Spring Web Starter and click on next.

![Screenshot 2019-07-02 at 11 12 36 PM](https://user-images.githubusercontent.com/35020560/60537319-e56d3100-9d25-11e9-8928-0c416800042a.png)

4. Click on finish. after click spring boot project will start to download from server

![Screenshot 2019-07-02 at 11 12 59 PM](https://user-images.githubusercontent.com/35020560/60537347-f6b63d80-9d25-11e9-8e86-c2a2b9efef0b.png)

5. Now we want to create index.jsp page.

You can create a any webpage or any jsp page provided which is belongs to a `webapp` folder.
for that we just need to create a folder `webapp` under the `/MyWebApp/src/main` folder. and inside of this webapp folder you can create any number of pages.


![Screenshot 2019-07-02 at 11 21 55 PM](https://user-images.githubusercontent.com/35020560/60537370-03d32c80-9d26-11e9-9962-a4e3acc727ca.png)

6. Create `home.jsp` page

![Screenshot 2019-07-02 at 11 22 25 PM](https://user-images.githubusercontent.com/35020560/60537384-0d5c9480-9d26-11e9-8680-31666cfecda6.png)

7. Now what a want is whenever I request for `home` application should call `home.jsp` page. To handle this requests we required one controller class.

![Screenshot 2019-07-02 at 11 23 57 PM](https://user-images.githubusercontent.com/35020560/60537414-1b121a00-9d26-11e9-923a-b7f0fcda71ad.png)

```
@Controller
public class HomeController {

	@RequestMapping("/home")
	public String homePage() {
		System.out.println("home");
		
		return "home.jsp";
	}
	
}

```
To run a spring boot application you don't need external server. If you expand maven dependencies, you will see embedded tomcat dependency available Because of this deployment of application become easier.

![Screenshot 2019-07-02 at 11 54 12 PM](https://user-images.githubusercontent.com/35020560/60537466-341acb00-9d26-11e9-908b-1fbfe603c1e3.png)

Now how spring boot knows where to search? Suppose you might be having different folders how it knows we have to search in the `webapp` and that is done in spring boot, So spring boot has this auto configuration stuff which is actually searching In the configuration they have mentioned that your pages will be the inside webapp If you are changing the path, then you have to do some configuration.

Now launch the server and try to access URL `http: //localhost: 8080/home` application will download home page. Because spring boot by default not support jsp Because his work is resend a response. Example @ResponseBody but we don't want to view the data we want to show the page. In that case we need to add support, i.e. we have to add one dependency called tomcat jasper in pom.xml


![Screenshot 2019-07-02 at 11 52 31 PM](https://user-images.githubusercontent.com/35020560/60537435-25341880-9d26-11e9-8766-d9cb1c15e940.png)


```
<!-- https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-jasper -->
<dependency>
    <groupId>org.apache.tomcat</groupId>
    <artifactId>tomcat-jasper</artifactId>
    <version>9.0.21</version>
</dependency>

```

pick up the same version dependancies of your tomcat version in maven dependancies.

![Screenshot 2019-07-03 at 12 34 09 AM](https://user-images.githubusercontent.com/35020560/60539435-56aee300-9d2a-11e9-913c-c5fce6ffe02a.png)


##### Example : MyWebApp project directory
