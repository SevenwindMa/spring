package com.programcreek.helloworld.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programcreek.dao.UserMapper;
import com.programcreek.model.UserExample;

@Controller
public class UserController {

	@Autowired
	UserMapper userMapper;
	@RequestMapping(value = "getTotalNumber", method = RequestMethod.GET)
	public ModelAndView getNumer(){
		ModelAndView model = new ModelAndView("userController");
		String name = "sean";
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name);
		int num = userMapper.countByExample(example);
		model.addObject("number", num);
		return model;
	}
	
	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
}
