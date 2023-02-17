package com.solvd.atm.models;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "modelCheck")
@XmlAccessorType(XmlAccessType.FIELD)
public class Check {
    @XmlAttribute
    private long idCheck;
    @XmlElement
    private User user;
    @XmlElement
    private Account account;
    @XmlElement
    private String operation;
    @XmlElement
    private double amount;

    public Check () {

    }

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

    public long getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(long idCheck) {
        this.idCheck = idCheck;
    }

    @Override
    public String toString() {
        return "Check{" +
                "idCheck=" + idCheck +
                ", user=" + user +
                ", account=" + account +
                ", operation='" + operation + '\'' +
                ", amount=" + amount +
                '}';
    }
}
