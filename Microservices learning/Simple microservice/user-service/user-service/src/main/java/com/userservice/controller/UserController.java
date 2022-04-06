package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public String get(){
        return "Welcome";
    }

    /**
     * RestTemplate used to communicate one microservice to another microservice
     */
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    /**
     * in other URL host contact-service instead of host:port it's worked by registering with microservices
     * @param userId
     * @return
     */
    @RequestMapping(value = "/id/{userId}",method = RequestMethod.GET)
    public User getUserInfo(@PathVariable("userId") Long userId){
        // http://localhost:1002/contact/id/1003
        User user=userService.getUser(userId);
        user.setContacts(restTemplate.getForObject("http://contact-service/contact/id/"+user.getUserId(), List.class));
        return user;
    }
}
