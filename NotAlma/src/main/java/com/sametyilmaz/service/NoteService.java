package com.sametyilmaz.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sametyilmaz.dao.NoteDAO;
import com.sametyilmaz.dto.UserLoginDTO;
import com.sametyilmaz.entity.Note;
import com.sametyilmaz.entity.User;
import com.sametyilmaz.security.LoginFilterr;

@Service
@Transactional
public class NoteService {

	@Autowired
	private UserService userService; //User servisi baglandi
	
	@Autowired
	private NoteDAO noteDAO; //Notun DAO su baglandi 
	
	public Long createNote(Note note,HttpServletRequest request) //yeni not olusturuldu
	{
		//TODO
		note.setUser_id(LoginFilterr.user.getId());
		return noteDAO.insert(note);
		
	}
	
	public Long updateNote(Note note,HttpServletRequest request) //var olan not guncellendi
	{
		
	 noteDAO.update(note);
	 return 1l;
		
	}
	
	public Long deleteNote(Note note,HttpServletRequest request) //var olan not silindi
	{
		
	 noteDAO.delete(note);
	 return 1l;
		
	}
	
public Note getNoteFindById(Long id) {
		
		return noteDAO.getFindById(id);

	}
	
	
	public ArrayList<Note> getAll() {
		
		return noteDAO.getAll();

	}
	
	public ArrayList<Note> getAll(Long user_id) {
		
		return noteDAO.getAll(user_id);

	}
public ArrayList<Note> getAll(UserLoginDTO login) { //buradan rest islemi sirasinda username ve password e ait kisinin tum notlari getirilir
	User usern=new User();
	usern.setUsername(login.getUsername());
	usern.setPassword(login.getPassword());
		User user=userService.getFindByUsernameAndPass(usern);
		return noteDAO.getAll(user.getId());

	}

}
