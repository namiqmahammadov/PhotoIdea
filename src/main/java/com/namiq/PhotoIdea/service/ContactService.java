package com.namiq.PhotoIdea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.entitiy.Contact;
import com.namiq.PhotoIdea.repository.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// Yeni əlaqə məlumatını əlavə et
	public Contact saveContact(Contact contact) {
		return contactRepository.save(contact);
	}

	// Bütün əlaqələri gətir
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	// Əlaqə məlumatını ID ilə tap
	public Contact getContactById(Long id) {
		return contactRepository.findById(id).orElse(null);
	}
}
