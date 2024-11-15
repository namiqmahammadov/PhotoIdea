package com.namiq.PhotoIdea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.namiq.PhotoIdea.exception.UserExistsException;
import com.namiq.PhotoIdea.repository.UserRepository;
import com.namiq.PhotoIdea.request.User;
import com.namiq.PhotoIdea.service.UserService;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    // İstifadəçi əlavə et
    @PostMapping
    public User addUser(@RequestBody User user) {
        if (userRepository.existsById(user.getEmail())) {
            throw new UserExistsException("Bu istifadəçi adı artıq mövcuddur");
        }
        return userService.addUser(user);
    }

    // Parolu yenilə
    @PutMapping("/password")
    public void editPassword(@RequestBody User user) {
        userService.editPassword(user);
    }

    // Giriş əməliyyatı (Boş metod - əlavə funksionallıq üçün ayrılmışdır)
    @GetMapping("/login")
    public void login() {
        // Giriş funksionallığı üçün boş metod, gələcəkdə əlavə edilə bilər.
    }
}
