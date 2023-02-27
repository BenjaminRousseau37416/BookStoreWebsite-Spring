package com.spring.henallux.firstSpringProject.service;

import com.spring.henallux.firstSpringProject.model.Book;
import com.spring.henallux.firstSpringProject.model.Promotion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PromotionService
{
    public void discount(ArrayList<Promotion> promotions, ArrayList<Book> books)
    {
        Date date = new Date();
        for (Promotion promotion: promotions)
        {
            for (Book book: books)
            {
                if (promotion.getCategory().getId() == book.getCategory().getId() && promotion.getStartDate().before(date) && promotion.getEndDate().after(date) )
                {
                    book.setPriceWithPromotion(book.getPrice(),promotion);
                }
            }
        }

    }

    public void discount(ArrayList<Promotion> promotions, Book book)
    {
        Date date = new Date();
        for (Promotion promotion: promotions)
        {
            if (promotion.getCategory().getId() == book.getCategory().getId() && promotion.getStartDate().before(date) && promotion.getEndDate().after(date))
            {
                book.setPriceWithPromotion(book.getPrice(),promotion);
            }
        }
    }
}
