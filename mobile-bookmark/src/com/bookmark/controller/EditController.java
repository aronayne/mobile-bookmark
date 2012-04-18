package com.bookmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditController {

	  @RequestMapping("/edit")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("edit", "message", "");
	  }
	  
}
