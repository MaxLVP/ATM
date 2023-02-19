package com.solvd.atm.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.atm.utils.parsers.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "accountModel")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName(value = "accountModel")
public class Account {
    @XmlAttribute
    @JsonProperty("idAccount")
    private long idAccount;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("openingDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    private Date openingDate;
    @XmlElement
    @JsonProperty("totalSum")
    private double totalSum;
    @XmlElement
    @JsonProperty("currency")
    private String currency;
    @XmlElement
    @JsonProperty("owner")
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
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public void decTotalSum(int sum) {
        totalSum -= sum;
    }

    public void incTotalSum(int sum) {
        totalSum += sum;
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
