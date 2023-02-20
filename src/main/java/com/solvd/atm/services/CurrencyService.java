package com.solvd.atm.services;

import com.solvd.atm.dao.ICurrencyDAO;
import com.solvd.atm.dao.mysql.CurrencyDAO;
import com.solvd.atm.models.Currency;

import java.util.List;

public class CurrencyService {
    private static final ICurrencyDAO CURRENCY_DAO = new CurrencyDAO();

    public static double getCourseByCurrency(String currencyName) {
        Currency currency = CURRENCY_DAO.getEntityByCurrencyName(currencyName);
        return currency.getCourse();
    }

    public static Currency getCurrencyByName(String currencyName) {
        return CURRENCY_DAO.getEntityByCurrencyName(currencyName);
    }

    public static boolean updateCurrency(Currency currency) {
        return CURRENCY_DAO.updateEntity(currency);
    }

    public static List<Currency> getListOfCurrency() {
        return CURRENCY_DAO.getAllCurrency();
    }
}
