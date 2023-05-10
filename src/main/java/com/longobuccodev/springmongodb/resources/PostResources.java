package com.longobuccodev.springmongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.longobuccodev.springmongodb.domain.Post;
import com.longobuccodev.springmongodb.resources.util.URL;
import com.longobuccodev.springmongodb.services.PostService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/posts")
public class PostResources {
	
	@Autowired
	private PostService service;
	
	

	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj =service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "")String text){
		text = URL.decodeParam(text);
		List<Post> list = service.finfByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "text",defaultValue = "")String text,
			@RequestParam(value = "minDate",defaultValue = "")String minDate,
			@RequestParam(value = "MaxDate",defaultValue = "")String maxDate){
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(minDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}

}