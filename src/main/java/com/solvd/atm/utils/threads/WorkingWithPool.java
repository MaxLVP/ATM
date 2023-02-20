package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.utils.MyLogger;

public class WorkingWithPool {
    private static final AccountPool ACCOUNT_POOL = new AccountPool();
    private static final MyLogger LOGGER = MyLogger.getInstance();

    public static Account getAccountFromPool(Card card) {
        if (card != null) {
            return ACCOUNT_POOL.getAccount(AccountService.getAccountByCard(card).getIdAccount());
        } else {
            LOGGER.info("Wrong card number");
        }
        return null;
    }

}
