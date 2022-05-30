package com.midterm.exam.controller;

import com.midterm.exam.entity.User;
import com.midterm.exam.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/")
    public String test(User user,Model model){
        user = new User();
        user.setName("Isi");
        user.setSurname("Moshumov");
        user.setEmail("mohsumov@gmail.com");
        model.addAttribute(user);
        userRepository.update("Test1",1l);

        return "test";
    }

    @PostMapping("/test-register")
    public String save(User user, Model model){
        log.trace("User is {}", user);
        return "test";
    }


    @RequestMapping(value = "hello",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name, Model model){
        model.addAttribute("greeting","Hello Spring"+name);
        return "hello";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name){
        return "hello" + name;
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }


}
