package com.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	private int id;
	private String email;
	private String mobile;
	private int userId;

	public static void main(String[] args) {
		System.out.println(new Contact());
	}
}
