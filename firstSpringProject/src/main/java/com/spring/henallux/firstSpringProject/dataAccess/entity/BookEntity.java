package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="book")
public class BookEntity
{
    @Id
    @Column(name="isbn")
    private String isbn;

    @Column(name="label")
    private String label;

    @Column(name="price")
    private double price;

    @Column(name="img")
    private String imgPath;

    @JoinColumn(name="category",referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
