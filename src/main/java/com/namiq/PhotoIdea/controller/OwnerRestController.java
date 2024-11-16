package com.namiq.PhotoIdea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namiq.PhotoIdea.entitiy.Owner;
import com.namiq.PhotoIdea.service.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerRestController {

	@Autowired
	private OwnerService ownerService;

	// Yeni obyekt sahibi əlavə et
	@PostMapping
	public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
		return new ResponseEntity<>(ownerService.saveOwner(owner), HttpStatus.CREATED);
	}

	// Bütün obyekt sahiblərini gətir
	@GetMapping
	public ResponseEntity<List<Owner>> getAllOwners() {
		return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.OK);
	}

	// ID ilə obyekt sahibini tap
	@GetMapping("/{id}")
	public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
		Owner owner = ownerService.getOwnerById(id);
		if (owner != null) {
			return new ResponseEntity<>(owner, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// E-poçt ilə obyekt sahibini tap
	@GetMapping("/email/{email}")
	public ResponseEntity<Owner> getOwnerByEmail(@PathVariable String email) {
		Owner owner = ownerService.getOwnerByEmail(email);
		if (owner != null) {
			return new ResponseEntity<>(owner, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Obyekt sahibini sil
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
		ownerService.deleteOwner(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
