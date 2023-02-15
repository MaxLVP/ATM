package com.solvd.atm.models;

public class Bill {
    private long idBill;
    private int rating;
    private int count;

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
}
