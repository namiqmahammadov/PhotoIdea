package com.namiq.PhotoIdea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.namiq.PhotoIdea.entitiy.Session;
import com.namiq.PhotoIdea.service.SessionService;

@RestController
@RequestMapping(path = "/sessions")
@CrossOrigin(origins = "*")
public class SessionRestController {
	@Autowired
	private SessionService sessionService;

	@GetMapping
	public ResponseEntity<List<Session>> getAllSessions() {
		return new ResponseEntity<>(sessionService.getAllSessions(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Session> addSession(@RequestBody Session session) {
		session.setId(null);
		return new ResponseEntity<>(sessionService.addSession(session), HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Session> updateSession(@PathVariable Integer id, @RequestBody Session session) {
		 Session existingSession = sessionService.findById(id);
		    session.setId(existingSession.getId()); 
		return new ResponseEntity<>(sessionService.updateSession(session), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteSession(@PathVariable Integer id) {
	    sessionService.deleteSession(id);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@GetMapping("/search")
	public ResponseEntity<List<Session>> searchSessions(@RequestParam String keyword) {
		return new ResponseEntity<>(sessionService.searchSessions(keyword), HttpStatus.OK);
	}

}
