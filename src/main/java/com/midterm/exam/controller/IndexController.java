package com.midterm.exam.controller;

import com.midterm.exam.entity.User;
import com.midterm.exam.repository.UserRepository;
import com.midterm.exam.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String index(HttpSession httpSession){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){

        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) throws Exception {
        httpSession.invalidate();
        return "redirect:/login";
    }


}
