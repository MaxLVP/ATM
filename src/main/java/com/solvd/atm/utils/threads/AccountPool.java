package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AccountPool {
    private static final Queue<Account> accountsPool = new ConcurrentLinkedQueue<>();

    public static void addAccountToPool(Account account) {
        accountsPool.add(account);
    }

    public synchronized Account getAccount() {
        if(accountsPool.size() > 0) {
            return accountsPool.poll();
        }
        else {
            while (accountsPool.size() == 0) {
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
