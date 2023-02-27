package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="promotion")
public class PromotionEntity
{
    @Id
    @Column(name="id")
    private int id;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="percentage")
    private int percentage;

    @JoinColumn(name="category",referencedColumnName = "id")
    @OneToOne
    private CategoryEntity category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
