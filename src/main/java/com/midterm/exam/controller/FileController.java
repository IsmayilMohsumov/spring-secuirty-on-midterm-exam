package com.midterm.exam.controller;

import com.midterm.exam.entity.User;
import com.midterm.exam.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class FileController {
    private final String LOCALHOST = "http://localhost:8081/";
    private final FileService fileService;

    @PostMapping("/file")
    public String addFile(@RequestParam("myfile") MultipartFile file, HttpSession session, Model model) throws IOException {
        if(session.getAttribute("login") != null){
            return "redirect:/index";
        }
        String mylocation = System.getProperty("user.dir") + "/src/main/resources/static/";
        String filename = file.getOriginalFilename();

        File mySavedFile = new File(mylocation + filename);

        InputStream inputStream = file.getInputStream();

        OutputStream outputStrea = new FileOutputStream(mySavedFile);

        int read = 0 ;
        byte [] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1){
            outputStrea.write(bytes, 0 , read);
        }

        String myLink =LOCALHOST + filename;

        User user = (User) session.getAttribute("loggedIn");
        log.trace("User is {}",user );
        com.midterm.exam.entity.File fileUpload = new com.midterm.exam.entity.File();
        fileUpload.setFileName(myLink);

        com.midterm.exam.entity.File byUserId = fileService.findByUserId(user);
        if(byUserId != null){
            byUserId.setFileName(myLink);
            fileService.save(byUserId);
            model.addAttribute("status","Document updated successfully!");
        }else{
            fileUpload.setUser(user);
            fileService.save(fileUpload);
            model.addAttribute("status","Document added successfully!");

        }

        model.addAttribute("userDetails",session.getAttribute("loggedIn"));
        return "user-profile";
    }
}
