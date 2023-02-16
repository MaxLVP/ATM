package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;
import com.solvd.atm.services.AccountService;

public class WorkingWithPool {
    private static final AccountPool ACCOUNT_POOL = new AccountPool();

    public static Account getAccountFromPool(Card card) {
        return ACCOUNT_POOL.getAccount(AccountService.getAccountByCard(card).getIdAccount());
    }

}
