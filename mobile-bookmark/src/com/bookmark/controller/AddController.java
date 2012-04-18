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
public class AddController {

	@RequestMapping("/add")
	  public ModelAndView helloWorld() {
	    return new ModelAndView("add", "message", "");
	  }
	  
	  @RequestMapping(value = ControllerServletConstants.ADD_BOOKMARK, method = RequestMethod.GET)
	  public @ResponseBody String getUrl(@RequestParam String urlVal, @RequestParam String date) throws EntityNotFoundException {		
	    DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();

	    String currentJson = this.getJsonFromStore();
	    BookmarkNodes bookmarkNodes = new Gson().fromJson(currentJson, BookmarkNodes.class);
	    BookmarkDetails bookmarkDetails = new BookmarkDetailsImpl();
	    bookmarkNodes.getNodes().add(bookmarkDetails);

	    Text datastoreJsonString = new Text(new Gson().toJson(bookmarkNodes));
	    Entity urlEntity = new Entity(ControllerServletConstants.KEY_KIND , ControllerServletConstants.KEY_NAME);
	    urlEntity.setProperty(ControllerServletConstants.JSON_BOOKMARK_VALUE, datastoreJsonString);
	  
	    datastoreService.put(urlEntity);   
	    
	    return urlVal;
	  }

	  private String getJsonFromStore() throws EntityNotFoundException{
		    Key key = KeyFactory.createKey(ControllerServletConstants.KEY_KIND, ControllerServletConstants.KEY_NAME);
		    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		    
		    Entity entity = datastore.get(key);
		    Text urlValInDB = (Text)entity.getProperty(ControllerServletConstants.JSON_BOOKMARK_VALUE);
		    
		    /**
		     * If this is the first bookmark being added, setup the json string
		     */
		    if(!urlValInDB.getValue().equalsIgnoreCase("{ nodes:[ ] }")){
		    	return "{ nodes:[ ] }";
		    }
		    else {
		    	return urlValInDB.getValue();
		    }
	  }
	  
}
