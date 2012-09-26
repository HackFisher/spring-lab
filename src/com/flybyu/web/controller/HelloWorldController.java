package com.flybyu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	@RequestMapping(value="/helloWorld", method = RequestMethod.GET)
	@ResponseBody
	public Object helloWorld(Model model) {
		model.addAttribute("message", "Hello World!");
		java.util.Map map = new java.util.HashMap<String, String>();
		map.put("message", "Hello World");
		return map;
	}
}
