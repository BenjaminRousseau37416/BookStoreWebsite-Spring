package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.Cart;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.spring.henallux.firstSpringProject.Constants.Constants.CURRENT_CART;

@Controller
@RequestMapping(value = "/cart")
@SessionAttributes({"currentCart"})
public class CartController
{

    @ModelAttribute (CURRENT_CART)
    public Cart cart()
    {
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(@ModelAttribute(value=CURRENT_CART) Cart cart)
    {
        cart.getCartItems().forEach((key, value) -> {
            value.setTotalPrice();
        });
        cart.setTotalPrice(0);

        cart.getCartItems().forEach((key, value) -> {
            cart.setTotalPrice(value.getTotalPrice());
        });

        return "integrated:cart";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData() {
        return "redirect:/inscription";
    }

    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public String getItemRemove(@RequestParam("isbn") String productIsbn,@ModelAttribute(value=CURRENT_CART) Cart cart)
    {
        if(cart.getCartItems().containsKey(productIsbn))
        {
            cart.getCartItems().remove(productIsbn);
            cart.setNbItem(cart.getCartItems().size());
        }
        return "redirect:/cart";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String getNumberAdd(@RequestParam("isbn") String productIsbn,@ModelAttribute(value=CURRENT_CART) Cart cart)
    {
        cart.getCartItems().get(productIsbn).setQuantity(1);
        return "redirect:/cart";
    }

    @RequestMapping(value="/removeOne", method=RequestMethod.POST)
    public String getNumberRemove(@RequestParam("isbn") String productIsbn,@ModelAttribute(value=CURRENT_CART) Cart cart)
    {
        cart.getCartItems().get(productIsbn).setQuantity(-1);
        return "redirect:/cart";
    }

    @RequestMapping(value="/checkout", method=RequestMethod.POST)
    public String checkOut(@ModelAttribute(value=CURRENT_CART) Cart cart)
    {
        return "redirect:/cart";
    }

}
