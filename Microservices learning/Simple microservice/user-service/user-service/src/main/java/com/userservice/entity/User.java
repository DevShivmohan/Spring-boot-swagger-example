package com.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
	@NonNull
	private Long userId;
	@NonNull
	private String userName;
	private List<Contact> contacts = new ArrayList<>();
}
