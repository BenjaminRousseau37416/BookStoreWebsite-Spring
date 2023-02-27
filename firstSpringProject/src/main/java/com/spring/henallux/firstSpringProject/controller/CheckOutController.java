package com.spring.henallux.firstSpringProject.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.spring.henallux.firstSpringProject.dataAccess.dao.*;
import com.spring.henallux.firstSpringProject.dataAccess.entity.OrderEntity;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.*;
import com.spring.henallux.firstSpringProject.service.PaypalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


import static com.spring.henallux.firstSpringProject.Constants.Constants.CURRENT_CART;

@Controller
@RequestMapping(value = "/checkOut")
@SessionAttributes({"currentCart"})
public class CheckOutController
{
    private final OrderDetailsDataAccess orderDetailsDao;
    private final OrderDataAccess orderDao;
    private final ProviderConverter providerConverter;

    private PaypalService service;

    public static final String SUCCESS_URL = "success";
    public static final String CANCEL_URL = "cancel";

    @Autowired
    public CheckOutController(OrderDetailsDao orderDetailsDao, OrderDao orderDao ,ProviderConverter providerConverter , PaypalService service)
    {
        this.orderDetailsDao = orderDetailsDao;
        this.orderDao = orderDao;
        this.providerConverter = providerConverter;
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(@ModelAttribute(value=CURRENT_CART) Cart cart , Authentication authentication)
    {
        if(cart.getCartItems().size() > 0)
        {
            User userDetails = (User) authentication.getPrincipal();
            Order order = new Order(userDetails.getId());

            orderDao.saveOrder(order);

            cart.getCartItems().forEach((key, value) -> {
                OrderDetails orderDetails = providerConverter.cartItemToOrderDetails(value);
                orderDetails.setOrder(orderDao.orderById(userDetails.getId()).getId());
                orderDetailsDao.saveOrderDetailsEntity(orderDetails);
            });

            try {
                Payment payment = service.createPayment(cart.getTotalPrice(),"EUR", "paypal", "sale", "test",
                        "http://localhost:8082/BookStore/checkOut/" + CANCEL_URL,
                        "http://localhost:8082/BookStore/checkOut/" + SUCCESS_URL);
                for(Links link:payment.getLinks()) {
                    if(link.getRel().equals("approval_url")) {
                        return "redirect:"+link.getHref();
                    }
                }

            } catch (PayPalRESTException e) {

                e.printStackTrace();
            }
        }


        return "integrated:cart";
    }


    @RequestMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "redirect:/cart";
    }

    @RequestMapping(value = SUCCESS_URL)
    public String successPay(@ModelAttribute(value=CURRENT_CART) Cart cart,@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId , Authentication authentication) {
        try {
            Payment payment = service.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                User userDetails = (User) authentication.getPrincipal();
                cart.getCartItems().clear();
                cart.setTotalPrice(0);
                cart.setNbItem(cart.getCartItems().size());
                OrderEntity orderEntity = orderDao.orderById(userDetails.getId());
                orderEntity.setPayed(true);
                orderDao.updateOrder(orderEntity);
                return "redirect:/cart";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "integrated:welcome";
    }
}
