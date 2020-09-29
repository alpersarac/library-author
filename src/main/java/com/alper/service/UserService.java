package com.alper.service;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.alper.entity.User;
import com.alper.service.MailService;
import com.alper.dao.UserDAO;

@Service
@Transactional
public class UserService {
	@Autowired
	private MailService mailService;
	@Autowired
	private UserDAO UserDAO;
	
	//crud
	
	public Long insert(User user){
		String uuid = UUID.randomUUID().toString();
		user.setKeyreg(uuid);
		
		if(UserDAO.insert(user)>0){
				mailService.registerMail(user.getEmail(), user.getKeyreg());
		}
		return 1l;
	}
	public void update(User user){
		UserDAO.update(user);
		
	}
	//Read
	public User getFindByUserNameAndPass(String username, String pass){
		
		return UserDAO.getFindByUserNameAndPass(username,pass);
	}
	
	public User getFindByUserNameAndPass(User user){
		return UserDAO.getFindByUserNameAndPass(user.getUsername(),user.getPassword());
	}
	
	public boolean getFindByKey(String key){
		User user = UserDAO.getFindByKey(key);
		if(user!=null){
			user.setActive(true);
			update(user);
			return true;
		}else{
			return false;
		}
	}
}
