package com.solvd.atm.models;

import java.util.Date;

public class Account {
    private long idAccount;
    private Date openingDate;
    private double totalSum;
    private Currency currency;
    private User owner;

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

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

    @Override
    public String toString() {
        return "Account{" +
                "idAccount=" + idAccount +
                ", openingDate=" + openingDate +
                ", totalSum=" + totalSum +
                ", currency=" + currency +
                ", owner=" + owner +
                '}';
    }

    public Account(Currency currency) {
        this.currency = currency;
    }
}
