package com.bookmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookmark.domain.BookmarkDetails;
import com.bookmark.domain.BookmarkDetailsImpl;
import com.bookmark.domain.BookmarkNodes;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Text;
import com.google.gson.Gson;

@Controller
public class PageTwoController {

	private Text datastoreJsonString = new Text("{ nodes:[ ] }");
	private static final String KEY_NAME = "TESTER";
	
	  @RequestMapping("/page2")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("page2", "message", "");
	  }
	  
	  @RequestMapping(value = ControllerServletConstants.ADD_BOOKMARK, method = RequestMethod.GET)
	  public @ResponseBody String getUrl(@RequestParam String urlVal, @RequestParam String date) throws EntityNotFoundException {		
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	    String currentJson = this.getUrlJson();
	    BookmarkNodes bookmarkNodes = new Gson().fromJson(currentJson, BookmarkNodes.class);
	    BookmarkDetails bookmarkDetails = new BookmarkDetailsImpl();
	    bookmarkNodes.getNodes().add(bookmarkDetails);

	    datastoreJsonString = new Text(new Gson().toJson(bookmarkNodes));
	    Entity urlEntity = new Entity("json" , KEY_NAME);
	    urlEntity.setProperty("urlVal", datastoreJsonString);
	  
	    datastore.put(urlEntity);   
	    
	    return urlVal;
	  }

	  private String getUrlJson() throws EntityNotFoundException{
		    Key key = KeyFactory.createKey("json", KEY_NAME);
		    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		    
		    Entity entity = datastore.get(key);
		    Text urlValInDB = (Text)entity.getProperty("urlVal");
		    
		    return urlValInDB.getValue();
	  }
	  
}
