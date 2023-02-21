package com.solvd.atm.models;

public class Fine {
    private long idFine;
    private String nameFine;
    private double fineAmount;
    private String nameCurrency;

    public Fine() {
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public long getIdFine() {
        return idFine;
    }

    public String getNameCurrency() {
        return nameCurrency;
    }

    public String getNameFine() {
        return nameFine;
    }

    @Override
    public String toString() {
        return "Fine{" +
                "idFine=" + idFine +
                ", nameFine='" + nameFine + '\'' +
                ", fineAmount=" + fineAmount +
                ", nameCurrency='" + nameCurrency + '\'' +
                '}';
    }
}
