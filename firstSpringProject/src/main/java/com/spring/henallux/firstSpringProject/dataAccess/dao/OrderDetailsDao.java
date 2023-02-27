package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderDetailsEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderDetailsRepository;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderDetailsDao implements OrderDetailsDataAccess
{
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public OrderDetailsDao(OrderDetailsRepository orderDetailsRepository,ProviderConverter providerConverter)
    {
        this.orderDetailsRepository = orderDetailsRepository;
        this.providerConverter = providerConverter;
    }

    @Transactional
    public OrderDetailsEntity saveOrderDetailsEntity(OrderDetails orderDetails)
    {
        return orderDetailsRepository.save(providerConverter.orderDetailsModelToOrderDetailsEntity(orderDetails));
    }
}
