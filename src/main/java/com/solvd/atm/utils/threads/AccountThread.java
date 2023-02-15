package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;
import com.solvd.atm.services.AccountService;

public class AccountThread extends Thread{
    private Account account;


    public AccountThread(Card card) {
        this.account = AccountService.getAccountByCard(card);
    }

    public Account getAccount() {
        return this.account;
    }

    @Override
    public void run() {
        AccountPool accountPool = new AccountPool();
        account = accountPool.getAccount(this.account.getIdAccount());
    }
}
