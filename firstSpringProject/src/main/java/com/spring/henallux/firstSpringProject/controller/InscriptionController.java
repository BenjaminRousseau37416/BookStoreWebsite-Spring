package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDao;
import com.spring.henallux.firstSpringProject.dataAccess.dao.UserDataAccess;
import com.spring.henallux.firstSpringProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping(value = "/inscription")
public class InscriptionController
{
    private final UserDataAccess userdao;

    @Autowired
    public InscriptionController(UserDao userDao)
    {
        this.userdao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "integrated:inscription";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(@Valid @ModelAttribute(value="user") User newUser , final BindingResult errors)
    {
        List<User> users = userdao.findByUserNameOrEmailAddress(newUser.getUsername(),newUser.getEmailAddress());
        if(!errors.hasErrors() && users.isEmpty())
        {
            userdao.saveUser(newUser);
            return "redirect:/login";
        }
        else
        {
            return "integrated:inscription";
        }

    }
}
