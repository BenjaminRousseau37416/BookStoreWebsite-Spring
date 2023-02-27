package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.BookDao;
import com.spring.henallux.firstSpringProject.dataAccess.dao.BookDataAccess;
import com.spring.henallux.firstSpringProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/productDetails")
@SessionAttributes({"currentCart"})
public class ProductDetailsController
{
    private final BookDataAccess bookdao;

    @Autowired
    public ProductDetailsController(BookDao bookDao)
    {
        this.bookdao = bookDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,@RequestParam("isbn") String productIsbn)
    {
        Book bookDetails = bookdao.getBookByIsbn(productIsbn);
        model.addAttribute("book", bookDetails);
        return "integrated:/productDetails";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormData(@RequestParam("isbn") String productIsbn) {
        return "redirect:/addToCart?isbn=" + productIsbn;
    }
}
