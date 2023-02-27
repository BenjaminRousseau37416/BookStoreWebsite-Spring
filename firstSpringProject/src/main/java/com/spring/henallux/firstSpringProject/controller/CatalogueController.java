package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.*;
import com.spring.henallux.firstSpringProject.model.*;
import com.spring.henallux.firstSpringProject.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Locale;

import static com.spring.henallux.firstSpringProject.Constants.Constants.CURRENT_CART;

@Controller
@RequestMapping(value = "/catalogue")
@SessionAttributes({"currentCart"})
public class CatalogueController
{
    private final BookDataAccess bookdao;
    private final PromotionDataAccess promotiondao;
    private final NameDataAccess nameDao;

    private final PromotionService promotionService;

    @ModelAttribute (CURRENT_CART)
    public Cart cart()
    {
        return new Cart();
    }

    @Autowired
    public CatalogueController(BookDao bookDao, PromotionDao promotiondao, NameDao nameDao, PromotionService promotionService)
    {
        this.bookdao = bookDao;
        this.promotiondao = promotiondao;
        this.nameDao = nameDao;
        this.promotionService = promotionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model,@RequestParam(required = false) String category)
    {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Name> names;
        ArrayList<Promotion> promotions = promotiondao.getAllPromotion();

        if (category == null)
        {
            books = bookdao.getAllBook();
        }
        else
        {
            String[] categories = category.split(",");
            for (String splitCategory : categories)
            {
                books.addAll(bookdao.getBookbyCategory(Integer.parseInt(splitCategory)));
            }
        }
        promotionService.discount(promotions,books);
        model.addAttribute("books", books);

        Locale locale = LocaleContextHolder.getLocale();
        if (locale.getLanguage().equals("fr"))
        {
            names = nameDao.getAllByLanguageId(1);
        }
        else
        {
            names = nameDao.getAllByLanguageId(2);
        }
        model.addAttribute("names", names);
        model.addAttribute("promotions", promotions);

        return "integrated:catalogue";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String getFormDatas(Model model,@RequestParam("isbn") String productIsbn)
    {
        return "redirect:/addToCart?isbn=" + productIsbn;
    }
}
