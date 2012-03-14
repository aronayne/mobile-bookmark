package com.bookmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookmarkController {

	  @RequestMapping("/bookmark")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("options", "message", "");
	  }
	  
}
