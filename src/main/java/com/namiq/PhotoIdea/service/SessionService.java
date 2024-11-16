package com.namiq.PhotoIdea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.entitiy.Customer;
import com.namiq.PhotoIdea.entitiy.Session;
import com.namiq.PhotoIdea.exception.CustomerNotFoundException;
import com.namiq.PhotoIdea.exception.ResourceNotFoundException;
import com.namiq.PhotoIdea.exception.SessionNotFoundException;
import com.namiq.PhotoIdea.repository.SessionRepository;

@Service
public class SessionService {
	@Autowired
	private SessionRepository sessionRepository;

	public Session addSession(Session session) {
		return sessionRepository.save(session);
	}

	public List<Session> getAllSessions() {
		return sessionRepository.findAll();
	}

	public Session updateSession(Session session) {
		return sessionRepository.save(session);
	}

	public Session findById(Integer id) {
		Session object = null;
		Optional<Session> finded = sessionRepository.findById(id);

		if (finded.isPresent()) {
			object = finded.get();

			return object;
		}
//				else {
//					throw new UnauthorizedException("Access denied");
//				}

		else {
			throw new SessionNotFoundException("Musteri kodu tapılmadı :" + id);
		}

	}

	public void deleteSession(Integer id) {
	    Session session = sessionRepository.findById(id)
	            .orElseThrow(() -> new SessionNotFoundException("Session not found with id: " + id));
	    sessionRepository.delete(session);
	}

	public List<Session> searchSessions(String keyword) {
		return sessionRepository.findByTitleContaining(keyword);
	}
}
