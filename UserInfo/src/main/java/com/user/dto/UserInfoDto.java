package com.user.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
	private long userId;
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String emailId;
	private String address;
}
