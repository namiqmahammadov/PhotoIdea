package com.namiq.PhotoIdea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.namiq.PhotoIdea.exception.UserNotFoundException;
import com.namiq.PhotoIdea.repository.UserRepository;
import com.namiq.PhotoIdea.request.User;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // İstifadəçi tap
    public User findById(String email) {
        return repository.findById(email)
                .orElseThrow(() -> new UserNotFoundException("İstifadəçi tapılmadı: " + email));
    }

    // İstifadəçini yenilə
    public void editPassword(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        repository.save(user);
    }

    // İstifadəçi əlavə et
    public User addUser(User user) {
        user.setPassword(encodePassword(user.getPassword()));
        user.setEnabled(true);
        return repository.save(user);
    }

    // Şifrəni `bcrypt` ilə şifrələyir
    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
