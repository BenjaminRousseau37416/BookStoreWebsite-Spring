package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao implements UserDataAccess
{
    private final UserRepository userRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public UserDao(UserRepository userRepository,ProviderConverter providerConverter)
    {
        this.userRepository = userRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<User> getAllUser()
    {
        List <UserEntity> userEntities = userRepository.findAll();
        ArrayList<User> users = new ArrayList<>();
        for(UserEntity entity : userEntities)
        {
            User user = providerConverter.userEntityToUserModel(entity);
            users.add(user);
        }
        return users;
    }

    public User findByUserName(String userName)
    {
        UserEntity userEntity = userRepository.findByUserName(userName);

        return providerConverter.userEntityToUserModel(userEntity);
    }

    public ArrayList<User> findByUserNameOrEmailAddress(String userName,String emailAddress)
    {
        ArrayList<UserEntity> userEntity = userRepository.findByUserNameOrEmailAddress(userName,emailAddress);
        return providerConverter.userEntityToUserModelList(userEntity);
    }

    @Transactional
    public UserEntity saveUser(User user)
    {
        return userRepository.save(providerConverter.userModelToUserEntity(user));
    }

}
