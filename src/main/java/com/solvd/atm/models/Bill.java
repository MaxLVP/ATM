package com.solvd.atm.models;

import java.util.Comparator;

public class Bill {
    private long idBill;
    private int rating;
    private int count;

    private String currency;

    private long idCurr;
    private long idATM;

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

    public String getCurrency() {
        return currency;
    }

    public Bill(int rating, int count, String currency) {
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

    public static final Comparator<Bill> COMPARE_BY_RATING = new Comparator<Bill>() {
        @Override
        public int compare(Bill o1, Bill o2) {
            return o1.getRating() - o2.getRating();
        }
    };

    @Override
    public String toString() {
        return "Bill{" +
                "idBill=" + idBill +
                ", rating=" + rating +
                ", count=" + count +
                ", currency=" + currency +
                '}';
    }

    public long getIdBill() {
        return idBill;
    }

    public void setIdBill(long idBill) {
        this.idBill = idBill;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getIdCurr() {
        return idCurr;
    }

    public void setIdCurr(long idCurr) {
        this.idCurr = idCurr;
    }

    public long getIdATM() {
        return idATM;
    }

    public void setIdATM(long idATM) {
        this.idATM = idATM;
    }
}
