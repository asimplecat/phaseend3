package com.hcl.controller;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
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


import com.hcl.model.Task;
import com.hcl.model.User;
import com.service.TaskServiceImpl;
import com.service.UserServiceImpl;

@Controller
public class TaskController {
	
	@Autowired
	private TaskServiceImpl taskrepo;
	
	
	
	@GetMapping("/displayTask/{email}")
	public ModelAndView showTasks(@PathVariable("email") String email) {
		
		List<Task> t = taskrepo.filterByEmail(email);
		return new ModelAndView("displayTask" , "Tasklist" , t);
	}
	
	@GetMapping("/index")
	public ModelAndView homePage() {
		return new ModelAndView("home");
	}

	@GetMapping("/createTask")
	public ModelAndView addTask()
	{	
		return new ModelAndView("createTask");
	}
	
	@PostMapping("/createTask")
	public String addValid(@RequestParam("taskname") String taskname,
			@RequestParam("startdate") String startdate, 
			@RequestParam("enddate") String enddate,
			@RequestParam("description") String description,
			@RequestParam("email") String email, 
			@RequestParam("severity") String severity)
	{
		
		Date parsed;
		Date parsed2;
		try {
		    SimpleDateFormat format =
		        new SimpleDateFormat("yyyy-mm-dd");
		    parsed = format.parse(startdate);
		    parsed2 = format.parse(enddate);
		}
		catch(ParseException pe) {
		    throw new IllegalArgumentException(pe);
		}
		
		
		
		Task t = new Task();
		t.setTaskName(taskname);
		t.setStartDate(parsed);
		t.setEndDate(parsed2);
		t.setDescription(description);
		t.setEmail(email);
		t.setSeverity(severity);
		taskrepo.save(t);
		return "redirect:displayTask/" + email;
		
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable("id") Long id)
	{	
		String email = taskrepo.get(id).getEmail();
		taskrepo.delete(id);
		return "redirect:/displayTask/" + email; 
	}
	
	@GetMapping("/deleteTasks")
	public ModelAndView deleteTasks()
	{	
		return new ModelAndView("deleteTasks");
	}
	
	@PostMapping("/deleteTasks")
	public String deleteSubmit(@RequestParam("email") String email) {
		List<Task> t = taskrepo.filterByEmail(email);
		for (Task f : t)
		{
			taskrepo.delete(f.getId());
		}
		return "redirect:displayTask/" + email;
		//return new ModelAndView("displayTask" , "Tasklist" , taskrepo.filterByEmail(email));
	}
	
	@GetMapping("/updateTask/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		Task t = taskrepo.get(id);
		System.out.println("Task t is " + t);
		return new ModelAndView("updateTask" , "task" , t);
	}
	
	@PostMapping("/updateTask")
	public String update2(@RequestParam("id") Long id,
			@RequestParam("taskname") String taskname,
			@RequestParam("startdate") String startdate, 
			@RequestParam("enddate") String enddate,
			@RequestParam("description") String description,
			@RequestParam("email") String email, 
			@RequestParam("severity") String severity) {
		
		Date parsed;
		Date parsed2;
		try {
		    SimpleDateFormat format =
		        new SimpleDateFormat("yyyy-mm-dd");
		    parsed = format.parse(startdate);
		    parsed2 = format.parse(enddate);
		}
		catch(ParseException pe) {
		    throw new IllegalArgumentException(pe);
		}
		
		
		Task t = taskrepo.get(id);
		t.setTaskName(taskname);
		t.setStartDate(parsed);
		t.setEndDate(parsed2);
		t.setDescription(description);
		t.setEmail(email);
		t.setSeverity(severity);
		taskrepo.save(t);
		return "redirect:displayTask/" + email;
		//return new ModelAndView("displayTask" , "Tasklist" , taskrepo.filterByEmail(email));
	}
	
	
}
