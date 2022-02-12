package com.sametyilmaz.endpoint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sametyilmaz.dto.UserLoginDTO;
import com.sametyilmaz.entity.Note;
import com.sametyilmaz.service.NoteService;

@RestController
@RequestMapping(value = "/rest") //username ve password bilgileri ile rest atabiliyoruz o kullaniciya ait notlar getirilir postman vb. uygulamalar ile test edilir json formatında
public class NoteEndPoint {

	@Autowired
	private NoteService noteService;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Note>> getNotes(@RequestBody UserLoginDTO login) {

		return new ResponseEntity<>(noteService.getAll(login), HttpStatus.OK);

	}

}
