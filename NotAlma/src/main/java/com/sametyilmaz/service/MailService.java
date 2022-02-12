package com.sametyilmaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sametyilmaz.notalma.HomeController;

@Service
public class MailService { //siteye uye olurken mail gondermesi icin yazdigimiz mail servisi

	@Autowired
	private JavaMailSender mailSender;
	
	public void registerMail(String mail,String key) {
		
		
		SimpleMailMessage  email=new SimpleMailMessage();
		email.setFrom("yilmazzsamet1@gmail.com");
		email.setTo(mail);
		email.setSubject("Üyeliği Tamamla");
		email.setText("Üyeligi tamamlamak icin linke tiklayiniz.\n\n"
				+HomeController.url+"/reg/"+key);
		
		
		mailSender.send(email);
	}
	
	
}
