package com.solvd.atm.services;

import com.solvd.atm.dao.ICurrencyDAO;
import com.solvd.atm.dao.mysql.CurrencyDAO;
import com.solvd.atm.models.Currency;

public class CurrencyService {
    private static final ICurrencyDAO CURRENCY_DAO = new CurrencyDAO();

    public static double getCourseByCurrency(String currencyName) {
        Currency currency = CURRENCY_DAO.getEntityByCurrencyName(currencyName);
        return currency.getCourse();
    }
}
