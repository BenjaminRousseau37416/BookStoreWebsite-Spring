package com.spring.henallux.firstSpringProject.model;

import java.util.Date;

public class Order
{
    private int id;
    private Date date;
    private boolean payed;

    private int userId;

    public Order(int userId)
    {
        setDate(new Date());
        setUserId(userId);
        setPayed(false);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
