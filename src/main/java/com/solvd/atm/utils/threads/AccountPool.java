package com.solvd.atm.utils.threads;

import com.solvd.atm.models.Account;
import com.solvd.atm.utils.MyLogger;

import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AccountPool {
    private static final Queue<Account> accountsPool = new ConcurrentLinkedQueue<>();
    private static final MyLogger LOGGER = MyLogger.getInstance();

    public static void addAccountToPool(List<Account> accountList) {
        accountsPool.addAll(accountList);
    }

    public static void getAccountPool() {
        LOGGER.info(accountsPool);
    }

    public synchronized Account getAccount(Long id) {
        int size = accountsPool.size();
        Optional<Account> accountOptional = accountsPool.stream().filter(account1 -> account1.getIdAccount() == id).findFirst();
        if (accountOptional.isPresent()) {
            Account account1 = accountOptional.get();
            accountsPool.remove(account1);
            return account1;
        } else {
            while (accountsPool.size() != size) {
                try {
                    wait();
                    LOGGER.info("This account is busy now, try again later");
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
