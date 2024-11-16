package com.namiq.PhotoIdea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.entitiy.Owner;
import com.namiq.PhotoIdea.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	// Yeni obyekt sahibi əlavə et
	public Owner saveOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	// Bütün obyekt sahiblərini gətir
	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}

	// ID ilə obyekt sahibini tap
	public Owner getOwnerById(Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	// E-poçt ilə obyekt sahibini tap
	public Owner getOwnerByEmail(String email) {
		return ownerRepository.findByEmail(email);
	}

	// Obyekt sahibini sil
	public void deleteOwner(Long id) {
		ownerRepository.deleteById(id);
	}
}
