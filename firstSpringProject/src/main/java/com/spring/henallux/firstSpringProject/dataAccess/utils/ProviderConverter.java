package com.spring.henallux.firstSpringProject.dataAccess.utils;

import com.spring.henallux.firstSpringProject.dataAccess.entity.*;
import com.spring.henallux.firstSpringProject.model.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderConverter
{
    private final Mapper mapper = new DozerBeanMapper();

    public User userEntityToUserModel(UserEntity userEntity)
    {
        User user = mapper.map(userEntity,User.class);
        user.setAuthorities(userEntity.getAuthorities());
        user.setAccountNonExpired(userEntity.getNonExpired());
        user.setAccountNonLocked(userEntity.getNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        return user;
    }

    public ArrayList<User> userEntityToUserModelList(List<UserEntity> usersEntity)
    {
        ArrayList<User> users = new ArrayList<>();
        for (UserEntity userEntity:usersEntity)
        {
            User user = mapper.map(userEntity,User.class);
            user.setAuthorities(userEntity.getAuthorities());
            user.setAccountNonExpired(userEntity.getNonExpired());
            user.setAccountNonLocked(userEntity.getNonLocked());
            user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
            user.setEnabled(userEntity.getEnabled());
            users.add(user);
        }
        return users;
    }

    public UserEntity userModelToUserEntity(User user)
    {
        UserEntity userEntity = new UserEntity();
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userEntity.setAddress(user.getAddress());
        userEntity.setLastName(user.getLastName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setPhoneNumber(user.getPhoneNumber());
        userEntity.setEmailAddress(user.getEmailAddress());
        userEntity.setId(user.getId());
        userEntity.setAuthorities("ROLE_USER");
        userEntity.setNonExpired(true);
        userEntity.setNonLocked(true);
        userEntity.setCredentialsNonExpired(true);
        userEntity.setEnabled(true);
        return userEntity;
    }


    public Book bookEntityToBookModel(BookEntity bookEntity)
    {
        return mapper.map(bookEntity,Book.class);
    }

    public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity)
    {
        return mapper.map(promotionEntity,Promotion.class);
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity)
    {
        return mapper.map(categoryEntity,Category.class);
    }

    public Name nameEntityToNameModel(NameEntity nameEntity)
    {
        return mapper.map(nameEntity,Name.class);
    }

    public CartItem bookToCartItem(Book book)
    {
        CartItem cartItem = mapper.map(book,CartItem.class);
        if (book.getPriceWithPromotion() != 0.0)
            cartItem.setPrice(book.getPriceWithPromotion());
        else
            cartItem.setPrice(book.getPrice());

        return cartItem;
    }

    public OrderDetails cartItemToOrderDetails(CartItem cartItem)
    {
        OrderDetails orderDetails = mapper.map(cartItem,OrderDetails.class);
        orderDetails.setUnitPrice(cartItem.getPrice());
        orderDetails.setIsbn((cartItem.getIsbn()));

        return orderDetails;
    }

    public OrderDetailsEntity orderDetailsModelToOrderDetailsEntity(OrderDetails orderDetails)
    {
        return mapper.map(orderDetails,OrderDetailsEntity.class);
    }

    public OrderEntity orderModelToOrderEntity(Order order)
    {
        return mapper.map(order,OrderEntity.class);
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity)
    {
        return mapper.map(orderEntity,Order.class);
    }


}
