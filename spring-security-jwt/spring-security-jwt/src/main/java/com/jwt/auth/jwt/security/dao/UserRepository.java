package com.jwt.auth.jwt.security.dao;

import com.jwt.auth.jwt.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.userName =:email")
    public User getUserByUserName(@Param("email") String email);

    @Query(value = "select * from user",nativeQuery = true)
    public List<User> getAllUsers();
}
