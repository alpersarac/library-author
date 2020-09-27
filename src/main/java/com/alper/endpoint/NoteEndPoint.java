package com.alper.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alper.service.NoteService;

@RestController
@RequestMapping(value="/rest")
public class NoteEndPoint {
	
	@Autowired
	public NoteService noteService;

}
