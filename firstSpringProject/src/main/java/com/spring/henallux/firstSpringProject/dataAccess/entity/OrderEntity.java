package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="`order`")
public class OrderEntity
{
    @Id
    @Column(name="id")
    private int id;

    @Column(name="order_date")
    private Date date;

    @Column(name="payed")
    private boolean payed;

    @Column(name="user")
    private int userId;


    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
