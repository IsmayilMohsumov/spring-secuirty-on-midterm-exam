package com.midterm.exam.controller;

import com.midterm.exam.entity.File;
import com.midterm.exam.entity.User;
import com.midterm.exam.service.FileService;
import com.midterm.exam.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final FileService fileService;

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/users")
    public String register(@Valid User user, BindingResult binding, Model model){
        if(binding.hasErrors()){
            model.addAttribute("errorMessage",binding);
            return "register";
        } else if (userService.checkEmailIfExists(user.getEmail())) {
            model.addAttribute("emailStatus","Email already taken please go to login page");
            return "register";
        } else{
            userService.addUser(user);
            model.addAttribute("success","User successfully registered!");
            return "index";
        }

    }

    @PostMapping("/login-user")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession httpSession) throws Exception {
        User user;
        if(userService.checkUser(email,password).isPresent()){
            user = userService.checkUser(email, password).get();
            model.addAttribute("userDetails",user);

            httpSession.setAttribute("loggedIn",user);

            if(user.getRole().equalsIgnoreCase("Admin")){
                List<File> files = userService.getAllFiles();
                log.trace("file is {}",files);
                httpSession.setAttribute("filesForAdmin",files);
                model.addAttribute("files",files);
                return "admin-profile";
            }else{
                httpSession.setAttribute("login","user");
                File byUserId = fileService.findByUserId(user);
                model.addAttribute("fileExistence",byUserId);
                return "user-profile";
            }

        }else{
            model.addAttribute("errorMessage","Bad Credentials");
            return "login";
        }

    }







}
