package com.solvd.atm.models;

import java.util.ArrayList;

public class ATM {
    //use stream and filter by currencies
    private long id;
    private String name;
    private ArrayList<Bill> bills;
    private Card card;

    public ATM(long id) {
        this.id = id;
    }

    public ATM() {
        card = null;
        bills = new ArrayList<>();
        //fill ATM with bills
//        Currency BYN = new Currency("BYN", 2.56);
//        Currency USD = new Currency("USD", 1);
//        Bill byn5 = new Bill(5, 200, "BYN");
//        Bill byn10 = new Bill(10, 10, "BYN");
//        Bill byn50 = new Bill(50, 5, "BYN");
//        Bill byn20 = new Bill(20, 70, "BYN");
//        Bill byn100 = new Bill(100, 20, "BYN");
//        Bill byn500 = new Bill(500, 5, "BYN");
//        Bill usd20 = new Bill(20, 10, "USD");
//        bills.add(byn5);
//        bills.add(byn10);
//        bills.add(byn20);
//        bills.add(byn50);
//        bills.add(byn100);
//        bills.add(byn500);
//        bills.add(usd20);
//        card = new Card(new Account());
//        card.getAccount().setCurrency("BYN");
        //fill ATM with bills
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
