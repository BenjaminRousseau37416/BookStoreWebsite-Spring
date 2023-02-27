package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.model.User;

import java.util.ArrayList;

public interface UserDataAccess
{
    ArrayList<User> getAllUser();
    User findByUserName(String userName);
    ArrayList<User> findByUserNameOrEmailAddress(String userName, String emailAddress);
    UserEntity saveUser(User user);
}
