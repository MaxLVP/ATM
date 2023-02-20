package com.solvd.atm.utils.exchange;

import com.solvd.atm.models.Currency;
import com.solvd.atm.services.CurrencyService;

import java.util.Objects;


public class Exchange {

    public static double getExchangeAmount(String cBefore, String cAfter, double amount) {
        Currency currencyBefore = CurrencyService.getCurrencyByName(cBefore);
        Currency currencyAfter = CurrencyService.getCurrencyByName(cAfter);
        if (Objects.equals(currencyBefore.getName(), currencyAfter.getName())) {
            return amount;
        } else {
            double course = CurrencyService.getCourseByCurrency(currencyBefore.getName());
            double amountToRUB = amount / course;
            return amountToRUB * CurrencyService.getCourseByCurrency(currencyAfter.getName());
        }
    }

}
