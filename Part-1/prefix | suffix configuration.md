
## Spring Boot (prefix | suffix configuration)

Normally, if you create an application, we don't put our all your pages in `webapp` folder because `webapp` is a folder which is public.

#### What if you want to make it private?
#### What if you want to put your pages in some other folder?

example: I want to move my pages in `/MyWebApp/src/main/webapp/pages` folder.  
normaly in spring application we are not write file extension or file name in controller for view.

```
 @RequestMapping("/home")
	public String homePage() {
		System.out.println("home");
		
		//return "home.jsp";

		return "home";
	}
	
 ```
![Screenshot 2019-07-03 at 9 24 59 PM](https://user-images.githubusercontent.com/35020560/60607232-86b5bf00-9dda-11e9-9e87-5e6ee07573d6.png)

Above we made first change is the location of the page and the second change dot jsp, I have removed the JSP part in the controller.

As we know we have a concept of auto configuration inside spring boot. Which is doing this stuff for you so the default folder is `webapp` and the extension is whatever you mention in the controller, But what if you configure above changes?

If you want to do any configuration we have a special file called as `application.properties` it belong to resources folder. Whatever configuration we want to do, we can do here.

In our case we have to specify two properties
1. prefix - path of the page is defined with this.
2. suffix - extension of the page is defined with the suffix.

![Screenshot 2019-07-03 at 9 25 53 PM](https://user-images.githubusercontent.com/35020560/60611621-6a1e8480-9de4-11e9-90eb-9bbac9674ac5.png)

#### Example : `MyWebApp` project directory
