package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long>{

}
