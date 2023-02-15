package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;

import static com.solvd.atm.atm_menu.working_with_card.MainMenu.mainCardMenu;

public class AccountThread extends Thread{
    private Account account;

    public void getAccountByCard(Card card) {
        account = card.getAccount();
    }

    @Override
    public void run() {
        AccountPool accountPool = new AccountPool();
        Account account = accountPool.getAccount(this.account);
        mainCardMenu(account);
        accountPool.releaseAccount(account);
    }
}
