package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderDetailsEntity;
import com.spring.henallux.firstSpringProject.model.OrderDetails;

public interface OrderDetailsDataAccess
{
    OrderDetailsEntity saveOrderDetailsEntity(OrderDetails orderDetails);
}
