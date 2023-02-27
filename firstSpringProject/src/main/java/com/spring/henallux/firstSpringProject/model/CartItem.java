package com.spring.henallux.firstSpringProject.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CartItem
{
    private String isbn;
    private double price;
    private String label;
    private String imgPath;
    private int quantity = 0;
    private double totalPrice;
    private Category category;

    public CartItem(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImgPath() {
        return this.imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice()
    {
        Locale locale  = new Locale("en", "UK");
        String pattern = "##.##";

        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);

        String format = decimalFormat.format(this.price * this.quantity);
        this.totalPrice = Double.parseDouble(format);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity += quantity;

        if(this.quantity < 1)
            this.quantity = 1;
    }
}
