package com.alper.service;

import java.util.ArrayList;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alper.dao.NoteDAO;
import com.alper.entity.Note;

@Service
@Transactional
public class NoteService {
	
	@Autowired
	private NoteDAO noteDAO;
	
	public Long createNote(Note note,HttpServletRequest request){
		//TODO: USER ID DEÐÝÞECEK
		note.setUser_id(1l);
		return noteDAO.insert(note);
	}
	public Note getNoteFindById(Long id){	
		return noteDAO.getFindById(id);
	}
	public ArrayList<Note> getAll(){
		return noteDAO.getAll();
	}
	public ArrayList<Note> getAll(Long userId){
		return noteDAO.getAll();
	}
		
}
