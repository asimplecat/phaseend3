package com.hcl.controller;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.dao.UserRepository;
import com.hcl.model.Task;
import com.hcl.model.User;
import com.service.TaskServiceImpl;
import com.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl impl;
	
	
	
	@GetMapping("login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping("login")
	public String loginCheck(@RequestParam("username") String uname, @RequestParam("password") String password, ModelMap model) {
		User u = impl.login(uname, password);
		System.out.println("User is " + u);
		if (u == null)
		{
			//to do: error text showing login was incorrect
			return "";// new ModelAndView("login");
		}
		model.addAttribute("email" , u.getEmail());
		//return new ModelAndView("/welcome",model) ;
		return "redirect:displayTask/" + u.getEmail();
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	
	@PostMapping("/register")
	public ModelAndView registerCheck(@RequestParam("username") String uname, @RequestParam("email") String email ,@RequestParam("password") String password) {
		User u = new User();
		u.setUname(uname);
		u.setPassword(password);
		u.setEmail(email);
		impl.save(u);
		
		return new ModelAndView("/displayTask" , "email" , u.getEmail());
	}
	
	
}
