package com.alper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alper.sarac.HomeController;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void registerMail(String mail,String key){
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("alpersaracshopping@gmail.com");
		email.setTo(mail);
		email.setSubject("�yeli�i tamamlama");
		email.setText("�yeli�i tamamlamak i�in a�a��daki linke t�klay�n�z.\n\n"
				+HomeController.url+"/reg/"+key);
		
		mailSender.send(email);
	}
	
	
}
