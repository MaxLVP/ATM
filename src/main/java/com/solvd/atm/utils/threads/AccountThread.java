package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;
import com.solvd.atm.services.AccountService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.solvd.atm.atm_menu.working_with_card.CardMenu.cardMenu;
import static com.solvd.atm.atm_menu.working_with_card.MainMenu.mainCardMenu;

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
        AccountPool.getAccountPool();
        this.account = accountPool.getAccount(this.account.getIdAccount());
        AccountPool.getAccountPool();
    }
}
