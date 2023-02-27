package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.OrderRepository;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderDao implements OrderDataAccess
{
    private final OrderRepository orderRepository;
    private final  ProviderConverter providerConverter;

    @Autowired
    public OrderDao(OrderRepository orderRepository,ProviderConverter providerConverter)
    {
        this.orderRepository = orderRepository;
        this.providerConverter = providerConverter;
    }

    @Transactional
    public void saveOrder(Order order)
    {
        orderRepository.save(providerConverter.orderModelToOrderEntity(order));
    }

    public OrderEntity orderById(int id)
    {
        return orderRepository.findFirstByUserIdOrderByIdDesc(id);
    }

    @Transactional
    public void updateOrder(OrderEntity orderEntity)
    {
        orderRepository.save(orderEntity);
    }

}
