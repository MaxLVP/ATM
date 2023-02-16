package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.Account;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.utils.exchange.Exchange;

import java.util.Scanner;

public class AccountInfoMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void getMoneyInfo(Account account) {
        LOGGER.info("Select the currency in which you want to view the balance");
        LOGGER.info("1. USD");
        LOGGER.info("2. BYN");
        LOGGER.info("3. EUR");
        LOGGER.info("4. RUB");
        LOGGER.info("5. GBP");
        int chooseCurrency = SCANNER.nextInt();
        switch (chooseCurrency) {
            case 1 -> LOGGER.info("Your balance in USD " +
                    Exchange.getExchangeAmount(account.getCurrency(), "USD", account.getTotalSum()));
            case 2 -> LOGGER.info("Your balance in BYN " +
                    Exchange.getExchangeAmount(account.getCurrency(), "BYN", account.getTotalSum()));
            case 3 -> LOGGER.info("Your balance in EUR " +
                    Exchange.getExchangeAmount(account.getCurrency(), "EUR", account.getTotalSum()));
            case 4 -> LOGGER.info("Your balance in RUB " +
                    Exchange.getExchangeAmount(account.getCurrency(), "RUB", account.getTotalSum()));
            case 5 -> LOGGER.info("Your balance in GBP " +
                    Exchange.getExchangeAmount(account.getCurrency(), "GBP", account.getTotalSum()));
        }
    }
}
