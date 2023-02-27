package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>
{
    UserEntity findByUserName(String userName);
    ArrayList<UserEntity> findByUserNameOrEmailAddress(String userName, String emailAddress);
}
