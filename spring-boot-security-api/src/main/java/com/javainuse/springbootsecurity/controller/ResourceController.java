package com.javainuse.springbootsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ResourceController {
	
	
	
	
	@RequestMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}
	
	@RequestMapping("/helloadmin")
	public ResponseEntity<String> getAdmin(HttpServletRequest request)
	{
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		    System.out.println(token.getHeaderName()+" = "+token.getToken());
		    return ResponseEntity.ok("first");
	}

	@GetMapping("/getRequest")
    public Emp getBody() {
        return new Emp("dipak.aher","password");
    }

	
	@PostMapping("/postRequest")
    public String postBody(@RequestBody Emp emp) {
        return "Hello " + emp;
    }

	
	@GetMapping("/getMenu")
	public Menu getMenu() {
		 List<SubPermission> subPermission = new ArrayList<SubPermission>();
		SubPermission subpermission1  = new SubPermission("SubPermission1", "SubPermissionurl");
		SubPermission subpermission2  = new SubPermission("SubPermission2", "SubPermissionur2");
		subPermission.add(subpermission1); subPermission.add(subpermission2);
		
		Permission permission1 = new Permission("Permission1", "Permissionurl1", subPermission);
		Permission permission2 = new Permission("Permission2", "Permissionurl2", subPermission);
		
		
		List<Permission> permission = new ArrayList<>();
		permission.add(permission1); permission.add(permission2);
		
		Menu menu = new Menu("Menu", "Menuurl", permission);
		
		
		return menu;
	}
	
	
}
