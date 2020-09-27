package com.alper.sarac;

import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alper.entity.Note;
import com.alper.service.NoteService;


@Controller
public class HomeController {
	
	@Autowired
	private NoteService noteService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest req) {
		
		System.out.print(req.getRemoteAddr());
		model.addAttribute("baslik","NOTE APP");
		model.addAttribute("serverTime", "Özgür Yazlým sa" );
		
		return "index";
	}
	
	@RequestMapping(value = "/detay", method = RequestMethod.GET)
	public String homeS(Model model){
		
		
		return "detail";
	}
	@RequestMapping(value = "/ekle", method = RequestMethod.GET)
	public String ekle(Model model){
		
		
		return "addNote";
	}
	
	@RequestMapping(value = "/asd", method = RequestMethod.GET)
	public String ERROR(Model model) {
		
		
		model.addAttribute("serverTime", "Merhaba" );
		
		return "error_404";
	}
	@RequestMapping(value="/addNote",method=RequestMethod.POST)
	public ResponseEntity<String> addNote(@RequestBody Note note, HttpServletRequest request){
		System.out.print(note.toString());
		noteService.createNote(note,request);
		
		
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
}
