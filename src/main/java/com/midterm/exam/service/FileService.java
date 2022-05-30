package com.midterm.exam.service;

import com.midterm.exam.entity.File;
import com.midterm.exam.entity.User;
import com.midterm.exam.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    public List<File> getAll(){
        return fileRepository.findAll();
    }

    @Transactional
    public void save(File fileUpload) {
        fileRepository.save(fileUpload);
    }

    public File findByUserId(User user) {
        return fileRepository.findByUser(user);
    }
}
