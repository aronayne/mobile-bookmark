package com.bookmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageThreeController {

	  @RequestMapping("/page3")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("page3", "message", "");
	  }
	  
}
