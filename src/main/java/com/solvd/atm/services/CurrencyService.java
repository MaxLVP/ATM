package com.solvd.atm.services;

import com.solvd.atm.dao.IAccountDAO;
import com.solvd.atm.dao.ICurrencyDAO;
import com.solvd.atm.dao.mysql.CurrencyDAO;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Currency;

public class CurrencyService {
    private static final ICurrencyDAO CURRENCY_DAO = new CurrencyDAO();

    public static double calculateBalance(Account account, String currencyName) {
        double convertedBalance = 0;
        Currency currency = CURRENCY_DAO.getEntityByCurrencyName(currencyName);
        String nameCurrencyAccount = account.getCurrency().getName();
        System.out.println(nameCurrencyAccount);
        if (nameCurrencyAccount.equals(currencyName)) {
            convertedBalance = account.getTotalSum();
        } else if (!nameCurrencyAccount.equals("USD") && !currencyName.equals("USD")){
            convertedBalance = (account.getTotalSum() / currency.getCourse()) * currency.getCourse();
        } else {
            convertedBalance = account.getTotalSum() * currency.getCourse();
        }
        return convertedBalance;
    }
}
