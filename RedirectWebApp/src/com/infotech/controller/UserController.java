package com.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.User;
import com.infotech.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String registerPage(){
		return "register";
	}
	
	@RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
	public String registerSuccess(@RequestParam("name") String userName,@RequestParam("country") String country,@RequestParam(required=false,name="email") String email,@RequestParam(name="age") int age){
		User user = new User(userName, age, email, country);
		userService.createUser(user);
		return "redirect:/listUsers";
	}
	
	@RequestMapping(value="/listUsers",method=RequestMethod.GET)
	public ModelAndView registerSuccess(ModelAndView modelAndView ){
		modelAndView.setViewName("UserList");
		List<User> userList = userService.getUserList();
		modelAndView.addObject("userList",userList);
		return modelAndView;
	}
	
}
