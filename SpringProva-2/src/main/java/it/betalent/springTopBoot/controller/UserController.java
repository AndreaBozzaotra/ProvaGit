package it.betalent.springTopBoot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.betalent.springTopBoot.entity.User;
import it.betalent.springTopBoot.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Mostra il form di login
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    // Gestisce la richiesta di login
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            return "redirect:/login?error";
        }
    }

    // Mostra il form di registrazione
    @GetMapping("/submit")
    public String showRegistrationForm() {
        return "registrazione";
    }

    // Gestisce la richiesta di registrazione
    @PostMapping("/submit")
    public String register(String username, String password) {
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            return "redirect:/submit?error";
        } else {
        
            User newuser = new User();
            newuser.setUsername(username);
            newuser.setPassword(password);
            userRepository.save(newuser);
            return "redirect:/login";
        }
    }
}
