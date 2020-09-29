	package com.alper.sarac;

import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alper.entity.Note;
import com.alper.service.MailService;
import com.alper.service.NoteService;


@Controller
public class HomeController {
	public static String url="http://localhost:8080/notalma";
	@Autowired
	private NoteService noteService;
	
	@Autowired
	private MailService mailService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model,HttpServletRequest req) {
		
		System.out.print(req.getRemoteAddr());
		
		
		return "redirect:/index";
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homes(Model model,HttpServletRequest req) {
		
		System.out.print(req.getRemoteAddr());
		
		
		return "redirect:/index";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model,HttpServletRequest req) {
		
		System.out.print(req.getRemoteAddr());
		model.addAttribute("baslik","NOTE APP");
		model.addAttribute("serverTime", "Özgür Yazlým sa" );
		model.addAttribute("notlar",noteService.getAll(1l));
		
		return "index";
	}
	
	@RequestMapping(value = "/detay/{id}", method = RequestMethod.GET)
	public String homeS(@PathVariable("id") Long id, Model model){
		
		model.addAttribute("id",id);
		
		mailService.registerMail("alper.sarac42@gmail.com", "123");
		
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
	
	@RequestMapping(value="/updateNote",method=RequestMethod.POST)
	public ResponseEntity<String> updateNote(@RequestBody Note note, HttpServletRequest request){
		Note oldNote = noteService.getNoteFindById(note.getId());
		oldNote.setTitle(note.getTitle());
		oldNote.setContent(note.getContent());
		noteService.updateNote(oldNote,request);
		
		
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	@RequestMapping(value="/deleteNote",method=RequestMethod.POST)
	public ResponseEntity<String> deleteNote(@RequestBody Note note, HttpServletRequest request){
		Note oldNote = noteService.getNoteFindById(note.getId());
		
		
		noteService.deleteNote(oldNote, request);
		
		
		return new ResponseEntity<>("OK",HttpStatus.CREATED);
	}
	@RequestMapping(value="/getNotes",method=RequestMethod.POST)
	public ResponseEntity<ArrayList<Note>> getNotes(HttpServletRequest request){
	
		
		return new ResponseEntity<>(noteService.getAll(1l),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/getNote",method=RequestMethod.POST)
	public ResponseEntity<Note> getNotes(@RequestBody String id, HttpServletRequest request){
	
		
		return new ResponseEntity<>(noteService.getNoteFindById(Long.parseLong(id)),HttpStatus.CREATED);
	}
}
