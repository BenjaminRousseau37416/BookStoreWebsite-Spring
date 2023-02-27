package com.spring.henallux.firstSpringProject.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Book
{
    private String isbn;
    private double price;
    private double priceWithPromotion;
    private String label;
    private String imgPath;

    private Category category;

    public Book(){}

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

    public double getPriceWithPromotion() {
        return this.priceWithPromotion;
    }

    public void setPriceWithPromotion(double price , Promotion promotion)
    {
        Locale locale  = new Locale("en", "UK");
        String pattern = "##.##";

        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);

        double pricePromotion = (price/100)*promotion.getPercentage();

        String format = decimalFormat.format(price-pricePromotion);
        this.priceWithPromotion = Double.parseDouble(format);
    }

}