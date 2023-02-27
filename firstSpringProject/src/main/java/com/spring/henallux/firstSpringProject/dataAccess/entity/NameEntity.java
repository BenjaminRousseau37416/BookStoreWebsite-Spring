package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="name")
public class NameEntity
{
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @JoinColumn(name="category",referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name="language",referencedColumnName = "id")
    @ManyToOne
    private LanguageEntity language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
