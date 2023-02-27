package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.Constants.Constants;
import com.spring.henallux.firstSpringProject.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/")
@SessionAttributes({Constants.CURRENT_CART})
public class WelcomeController {

    protected static final String CURRENT_CART = "currentCart";

    @ModelAttribute (CURRENT_CART)
    public Cart cart()
    {
        return new Cart();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home()
    {
        return "integrated:welcome";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData() {
            return "redirect:/inscription";
    }
}
