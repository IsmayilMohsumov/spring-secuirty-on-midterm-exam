package com.midterm.exam.repository;

import com.midterm.exam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    public User getByEmailAndPassword(String email, String password);

    public User findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "update user set name = ?1 where id = ?2 ",nativeQuery = true)
    void update(String name, Long id);

    @Modifying
    @Transactional
    @Query(value = "update auth_user a  set A.DESCRIPTION=?1 where A.AUTH_USER_ID=?2",nativeQuery = true)
    public void  updateDesc(String description,Integer userId);

}
