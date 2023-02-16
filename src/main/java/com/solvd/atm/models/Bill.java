package com.solvd.atm.models;

import java.util.Comparator;

public class Bill {
    private long idBill;
    private int rating;
    private int count;

    private Currency currency;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Bill(int rating, int count) {
        this.rating = rating;
        this.count = count;
    }

    public int decCount(int delta) {
        count -= delta;
        return count;
    }

    public int incCount(int delta) {
        count += delta;
        return count;
    }
    public Currency getCurrency() {
        return currency;
    }
    public Bill(int rating, int count, Currency currency) {
        this.rating = rating;
        this.count = count;
        this.currency = currency;
    }

    public Bill() {
    }

    public static final Comparator<Bill> COMPARE_BY_COUNT = new Comparator<Bill>() {
        @Override
        public int compare(Bill o1, Bill o2) {
            return o1.getCount() - o2.getCount();
        }
    };
}
