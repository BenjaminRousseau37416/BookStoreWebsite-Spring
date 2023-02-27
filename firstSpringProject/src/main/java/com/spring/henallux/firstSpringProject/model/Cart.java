package com.spring.henallux.firstSpringProject.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

public class Cart
{
    private HashMap<String,CartItem> cartItems;
    private double totalPrice;
    private int nbItem;

    public Cart()
    {
        setCartItems();
        setNbItem(0);
        setTotalPrice(0);
    }

    public HashMap<String,CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems() {
        this.cartItems = new HashMap<>();
    }

    public void setCartItems(CartItem cartItem)
    {
        this.cartItems.put(cartItem.getIsbn(),cartItem);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double itemsTotalPrice)
    {
        if (itemsTotalPrice <= 0)
            this.totalPrice = 0;
        else
            {
                Locale locale  = new Locale("en", "UK");
                String pattern = "##.##";

                DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
                decimalFormat.applyPattern(pattern);

                String format = decimalFormat.format(this.totalPrice += itemsTotalPrice);
                this.totalPrice = Double.parseDouble(format);
            }

    }

    public int getNbItem() {
        return nbItem;
    }

    public void setNbItem(int number) {
        this.nbItem = number;
    }

}
