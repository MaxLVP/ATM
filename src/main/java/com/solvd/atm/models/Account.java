package com.solvd.atm.models;

import com.solvd.atm.utils.parsers.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "accountModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    @XmlAttribute
    private long idAccount;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date openingDate;
    @XmlElement
    private double totalSum;
    @XmlElement
    private String currency;
    @XmlElement
    private User owner = null;

    public Account() {

    }

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
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
                ", currency='" + currency + '\'' +
                ", owner=" + owner +
                '}';
    }
}
