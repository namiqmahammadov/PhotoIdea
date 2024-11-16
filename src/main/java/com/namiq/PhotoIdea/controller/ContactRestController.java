package com.namiq.PhotoIdea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namiq.PhotoIdea.entitiy.Contact;
import com.namiq.PhotoIdea.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactRestController {

	@Autowired
	private ContactService contactService;

	// Yeni əlaqə məlumatı əlavə et
	@PostMapping
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
		return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.CREATED);
	}

	// Bütün əlaqələri gətir
	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts() {
		return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
	}

	// ID ilə əlaqəni tap
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
		Contact contact = contactService.getContactById(id);
		if (contact != null) {
			return new ResponseEntity<>(contact, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
