package com.user.service;

import java.util.List;

import com.user.dto.UserInfoDto;

public interface UserInfoService {
	UserInfoDto addUser(UserInfoDto dto);
	UserInfoDto getUser(long id);
	UserInfoDto updateUserInfo(UserInfoDto dto,long id);
	List<UserInfoDto> getAllUserInfo();
	void deleteUser(long id);
}
