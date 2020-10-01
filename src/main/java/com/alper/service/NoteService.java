package com.alper.service;

import java.util.ArrayList;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alper.dao.NoteDAO;
import com.alper.dto.UserLoginDTO;
import com.alper.entity.Note;
import com.alper.entity.User;
import com.alper.security.LoginFilter;

@Service
@Transactional
public class NoteService {
	
	@Autowired
	private UserService UserService;
	
	@Autowired
	private NoteDAO noteDAO;
	
	public Long updateNote(Note note,HttpServletRequest request){
		noteDAO.update(note);
		return 1l;
	}
	public Long deleteNote(Note note,HttpServletRequest request){
		noteDAO.delete(note);
		return 1l;
	}
	public Long createNote(Note note,HttpServletRequest request){
		//TODO: USER ID DEÐÝÞECEK
		note.setUser_id(LoginFilter.user.getId());
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
	
	public ArrayList<Note> getAll(UserLoginDTO login){
		User userm = new User();
		userm.setSurname(login.getUsername());
		userm.setPass2(login.getPassword());
		User user = UserService.getFindByUserNameAndPass(userm);
		return noteDAO.getAll(user.getId());
	}
		
}
