package com.bookmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

	  @RequestMapping("/view")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("view", "message", "");
	  }
	  
}
