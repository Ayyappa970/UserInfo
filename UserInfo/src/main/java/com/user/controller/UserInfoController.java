package com.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.dto.UserInfoDto;
import com.user.service.UserInfoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/users")
public class UserInfoController {
	@Autowired
	private UserInfoService usService;
	
	@PostMapping("/addUser")
	public ResponseEntity addUser(@RequestBody UserInfoDto dto) {
		UserInfoDto user = usService.addUser(dto);
		return ResponseEntity.ok("New User Created By Id "+user.getUserId());
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserInfoDto> getUserInfo(@PathVariable("id") long id) {
		UserInfoDto user = usService.getUser(id);
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("updateUser/{id}")
	public ResponseEntity<UserInfoDto> updateUserInfo(@PathVariable long id, @RequestBody UserInfoDto dto) {
		UserInfoDto user = usService.updateUserInfo(dto, id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserInfoDto>> getAllUsers() {
		List<UserInfoDto> list = usService.getAllUserInfo();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
		usService.deleteUser(id);
		return ResponseEntity.ok("User deleted by Id "+id);
	}
	
}
