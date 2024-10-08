package com.user.mapper;

import com.user.dto.UserInfoDto;
import com.user.entity.UserInfo;

public class UserInfoMapper {
	public static UserInfo mapToUserInfo(UserInfoDto dto) {
		return new UserInfo(dto.getUserId(),dto.getFirstName().toUpperCase(),dto.getLastName().toUpperCase(),dto.getPhoneNumber(),dto.getEmailId().toLowerCase(),dto.getAddress());
	}
	public static UserInfoDto mapToUserInfoDto(UserInfo info) {
		return new UserInfoDto(info.getUserId(),info.getFirstName().toUpperCase(),info.getLastName().toUpperCase(),info.getPhoneNumber(),info.getEmailId().toLowerCase(),info.getAddress());
	}
}
