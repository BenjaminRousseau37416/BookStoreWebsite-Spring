package com.spring.henallux.firstSpringProject.mockito;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDao;
import com.spring.henallux.firstSpringProject.dataAccess.entity.UserEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.UserRepository;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class userDAOTest {
    private UserDao userDao;

    @Mock
    private UserRepository userRepository;
    @Mock
    private ProviderConverter providerConverter;

    @Before
    public void setUp(){
        userDao = new UserDao(userRepository, providerConverter);
    }

    @Test
    public void testGetAllUser() {
        List<UserEntity> userEntities = Arrays.asList(
                new UserEntity(),
                new UserEntity(),
                new UserEntity()
        );

        when(userRepository.findAll()).thenReturn(userEntities);
        when(providerConverter.userEntityToUserModel(any(UserEntity.class))).thenReturn(new User());
        List<User> users = userDao.getAllUser();
        verify(userRepository).findAll();
        verify(providerConverter, times(userEntities.size())).userEntityToUserModel(any(UserEntity.class));
        assertEquals(userEntities.size(), users.size());
    }
    @Test
    public void testFindByUserName() {

        UserEntity userEntity = new UserEntity();
        when(userRepository.findByUserName("testUser")).thenReturn(userEntity);
        User userExpected = new User();
        when(providerConverter.userEntityToUserModel(userEntity)).thenReturn(userExpected);

        User user = userDao.findByUserName("testUser");
        verify(userRepository).findByUserName("testUser");
        verify(providerConverter).userEntityToUserModel(userEntity);
        assertSame(userExpected, user);
    }

    @Test
    public void testSaveUser() {
        User user = new User();

        UserEntity userEntity = new UserEntity();

        when(providerConverter.userModelToUserEntity(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        UserDao userDao = new UserDao(userRepository, providerConverter);
        UserEntity savedUserEntity = userDao.saveUser(user);

        verify(providerConverter).userModelToUserEntity(user);
        verify(userRepository).save(userEntity);
        assertSame(userEntity, savedUserEntity);
    }

}
