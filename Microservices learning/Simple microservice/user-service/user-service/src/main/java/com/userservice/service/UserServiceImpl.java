package com.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.userservice.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private List<User> users = List.of(new User(100l, "Shivmohan"), new User(101l, "Vipul Kumar"),
			new User(102l, "Shiv"), new User(103l, "Kumar"), new User(104l, "Mohan"));

	/**
	 * lambda filter expression
	 * 
	 * @param userId
	 * @return
	 */
	@Override
	public User getUser(Long userId) {
		return this.users.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
	}
}
