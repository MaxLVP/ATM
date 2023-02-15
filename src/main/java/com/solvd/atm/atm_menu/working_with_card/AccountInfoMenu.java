package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Currency;
import com.solvd.atm.services.CurrencyService;
import com.solvd.atm.utils.MyLogger;

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
                    CurrencyService.calculateBalance(account, "USD"));
            case 2 -> LOGGER.info("Your balance in BYN " +
                    CurrencyService.calculateBalance(account, "BYN"));
            case 3 -> LOGGER.info("Your balance in EUR " +
                    CurrencyService.calculateBalance(account, "EUR"));
            case 4 -> LOGGER.info("Your balance in RUB " +
                    CurrencyService.calculateBalance(account, "RUB"));
            case 5 -> LOGGER.info("Your balance in GBP " +
                    CurrencyService.calculateBalance(account, "GBP"));
        }
    }
}
