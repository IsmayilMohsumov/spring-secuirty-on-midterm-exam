package com.midterm.exam.repository;

import com.midterm.exam.entity.File;
import com.midterm.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File,Long> {
    public File findByUser(User user);
}
