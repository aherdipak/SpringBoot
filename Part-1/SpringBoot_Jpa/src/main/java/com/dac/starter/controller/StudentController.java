package com.dac.starter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dac.starter.dao.StudentRepo;
import com.dac.starter.model.Student;

@Controller
public class StudentController {

	@Autowired
	StudentRepo stdRepo;
	// I am creating simply object of StudentRepo, no where i am creating a class here.
	// @Autowired - it will look for the object of StudentRepo & i have not created any 
	//class & any object and thats the beauty of our spring boot.
	
	@RequestMapping("/")
	public String home() {
		System.out.println("In Home");
		return "home.jsp";
	}

	@RequestMapping("/addStudent")
	public String addStudent(Student student) {
		stdRepo.save(student);
		return "home.jsp";
	}
	
	@RequestMapping("/viewStudent")
	public String viewStudent(HttpServletRequest req, Student student) {
		HttpSession session = req.getSession();
		List<Student> list =(List<Student>) stdRepo.findAll();
		session.setAttribute("studentList", list);
		return "home.jsp";
	}
	
	@RequestMapping("/viewStudentID")
	public ModelAndView viewStudentById(@RequestParam int stdId) {
		ModelAndView mv = new ModelAndView("home.jsp");
		Student student = stdRepo.findById(stdId).orElse(new Student());
		List<Student> list =new ArrayList<>();
		list.add(student);
		mv.addObject("studentList", list);
		return mv;
	}
	
	
	@RequestMapping("/deleteStudent")
	public String deleteStudent(Student student) {
		stdRepo.delete(student);
		return "home.jsp";
	}
	
	@RequestMapping("/findByTech")
	public ModelAndView findByTech(@RequestParam String tech) {
		ModelAndView mv = new ModelAndView("home.jsp");
		List<Student> list = stdRepo.findByStdTech(tech);
		System.out.println(list);
		System.out.println(stdRepo.findByStdTechSorted(tech));
		mv.addObject("studentList", list);
		return mv;
	}
	
	@RequestMapping("/findByIdGreaterThan")
	public ModelAndView findByIdGreaterThan(@RequestParam int stdId) {
		ModelAndView mv = new ModelAndView("home.jsp");
		List<Student> list = stdRepo.findByStdIdGreaterThan(stdId);
		System.out.println(list);
		mv.addObject("studentList", list);
		return mv;
	}
	
}
