package com.spring.henallux.firstSpringProject.controller;

import com.spring.henallux.firstSpringProject.dataAccess.dao.*;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.*;
import com.spring.henallux.firstSpringProject.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static com.spring.henallux.firstSpringProject.Constants.Constants.CURRENT_CART;

@Controller
@RequestMapping(value = "/addToCart")
@SessionAttributes({"currentCart"})
public class AddCartController
{
    private final BookDataAccess bookdao;
    private final PromotionDataAccess promotiondao;
    private final ProviderConverter providerConverter;

    private final PromotionService promotionService;

    @Autowired
    public AddCartController(BookDao bookDao, ProviderConverter providerConverter,PromotionDao promotiondao,PromotionService promotionService)
    {
        this.bookdao = bookDao;
        this.promotiondao = promotiondao;
        this.providerConverter = providerConverter;
        this.promotionService = promotionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(@RequestParam("isbn") String productIsbn, @ModelAttribute(value=CURRENT_CART) Cart cart)
    {
        Book book = bookdao.getBookByIsbn(productIsbn);
        ArrayList<Promotion> promotions = promotiondao.getAllPromotion();
        promotionService.discount(promotions,book);
        CartItem cartItem = providerConverter.bookToCartItem(book);

        if(!cart.getCartItems().containsKey(productIsbn))
        {
            cartItem.setQuantity(1);
            cartItem.setTotalPrice();
            cart.setCartItems(cartItem);
            cart.setNbItem(cart.getCartItems().size());
        }

        return "redirect:/cart";
    }
}
