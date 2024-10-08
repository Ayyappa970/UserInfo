package com.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dto.UserInfoDto;
import com.user.entity.UserInfo;
import com.user.mapper.UserInfoMapper;
import com.user.repository.UserRepository;


@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserRepository useRepository;

	@Override
	public UserInfoDto addUser(UserInfoDto dto) {
		UserInfo info = useRepository.save(UserInfoMapper.mapToUserInfo(dto));
		return UserInfoMapper.mapToUserInfoDto(info);
	}

	@Override
	public UserInfoDto getUser(long id) {
		UserInfo info = useRepository.findById(id).orElseThrow(()->new RuntimeException("No Account found by given Id"));
		return UserInfoMapper.mapToUserInfoDto(info);
	}

	@Override
	public UserInfoDto updateUserInfo(UserInfoDto dto, long id) {
		UserInfo info = useRepository.findById(id).orElseThrow(()->new RuntimeException("No Account found by given Id"));
		if (info!=null) {
			info.setFirstName(dto.getFirstName().toUpperCase());
			info.setLastName(dto.getLastName().toUpperCase());
			info.setPhoneNumber(dto.getPhoneNumber());
			info.setEmailId(dto.getEmailId().toLowerCase());
			info.setAddress(dto.getAddress());
			return UserInfoMapper.mapToUserInfoDto(useRepository.save(info));
		}else {
			return null;
		}
		
	}

	@Override
	public List<UserInfoDto> getAllUserInfo() {
		List<UserInfo> all = useRepository.findAll();
		if (all!=null) {
			return all.stream().map((UserInfo)->UserInfoMapper.mapToUserInfoDto(UserInfo)).collect(Collectors.toList());
		}else {
			return null;
		}
	}

	@Override
	public void deleteUser(long id) {
		UserInfo info = useRepository.findById(id).orElseThrow(()->new RuntimeException("No Account found by given Id"));
		useRepository.deleteById(id);
		
	}
}
