package com.solvd.atm.models;

public enum CurrencyInfo {
    BYN("BYN", new int[]{5, 10, 20, 50, 100, 200, 500}),
    RUB("RUB", new int[]{10, 50, 100, 200, 500, 1000, 2000}),
    EUR("EUR", new int[]{5, 10, 20, 50, 100, 200, 500}),
    USD("USD", new int[]{1, 2, 5, 10, 20, 50, 100}),
    GBP("GBP", new int[]{5, 10, 20, 50});
    public final String currencyString;
    public final int[] possibleValues;

    CurrencyInfo(String currencyString, int[] possibleValues) {
        this.currencyString = currencyString;
        this.possibleValues = possibleValues;
    }
}