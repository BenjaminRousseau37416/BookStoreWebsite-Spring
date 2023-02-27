package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import static com.spring.henallux.firstSpringProject.Constants.Constants.CURRENT_CART;

@Controller
@RequestMapping(value = "/aboutUs")
@SessionAttributes({"currentCart"})
public class AboutUsController
{
    @ModelAttribute(CURRENT_CART)
    public Cart cart()
    {
        return new Cart();
    }
    @RequestMapping(method = RequestMethod.GET)
    public String home()
    {
        return "integrated:aboutUs";
    }
    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData() {
        return "redirect:/inscription";
    }
}
