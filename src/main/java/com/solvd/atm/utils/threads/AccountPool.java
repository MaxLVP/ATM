package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AccountPool {
    private static final Queue<Account> accountsPool = new ConcurrentLinkedQueue<>();

    public static void addAccountToPool(List<Account> accountList) {
        accountsPool.addAll(accountList);
    }

    public synchronized Account getAccount(Account account) {
        if(accountsPool.contains(account)) {
            accountsPool.remove(account);
            return account;
        }
        else {
            while (!accountsPool.contains(account)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread Interrupted");
                }
            }
        }
        return null;
    }

    public synchronized void releaseAccount(Account account) {
        accountsPool.add(account);
        notify();
    }
}
