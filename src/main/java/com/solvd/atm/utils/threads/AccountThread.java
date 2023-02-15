package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;

import static com.solvd.atm.atm_menu.working_with_card.MainMenu.mainCardMenu;

public class AccountThread extends Thread{

    @Override
    public void run() {
        AccountPool accountPool = new AccountPool();
        Account account = accountPool.getAccount();
        mainCardMenu(account);
        accountPool.releaseAccount(account);
    }
}
