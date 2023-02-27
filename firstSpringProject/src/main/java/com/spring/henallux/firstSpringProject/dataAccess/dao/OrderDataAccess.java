package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.model.Order;


public interface OrderDataAccess
{
    void saveOrder(Order order);
    void updateOrder(OrderEntity orderEntity);
    OrderEntity orderById(int id);
}
