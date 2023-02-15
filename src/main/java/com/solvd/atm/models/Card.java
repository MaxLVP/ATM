package com.solvd.atm.models;

import java.util.Date;

public class Card {
    private long idCard;
    private String number;
    private User owner;
    private Account account;
    private String validityDate;
    private int cvv;
    private int pin;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User owner() {
        return owner;
    }

    public void setOwner(User holder) {
        this.owner = holder;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public long getId() {
        return idCard;
    }

    public void setId(long id) {
        this.idCard = id;
    }
}
