package com.solvd.atm.models;

import java.util.Date;

public class Account {
    private Date openingDate;
    private double totalSum;
    private Currency currency;
    private User owner;

    public Date getOpeningDate() {
        return openingDate;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.totalSum = currency.fromOldCourse(totalSum, this.currency.getCourse());
        this.currency = currency;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
