package com.solvd.atm.models;

public class Check {
    private User user;
    private Account account;
    private String operation;
    private double amount;

    public Check(User user, Account account, String operation, double amount) {
        this.user = user;
        this.account = account;
        this.operation = operation;
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
