package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Check;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.utils.collections.AllChecksCollection;
import com.solvd.atm.utils.exchange.Exchange;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TransferMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String OPERATION_NAME = "Transfer money between accounts";

    public static void transferMoneyFromAccount(Account account) {
        LOGGER.info("Choose where you want to transfer money");
        LOGGER.info("1. Between you accounts");
        LOGGER.info("2. Transfer to another account");
        int point = SCANNER.nextInt();
        switch (point) {
            case 1 -> transferMoneyBetweenUserAccounts(account);
            case 2 -> transferToAnyAccount(account);
            default -> {
                LOGGER.info("You choose invalid point, try again :(");
                transferMoneyFromAccount(account);
            }
        }
    }

    public static void transferMoneyBetweenUserAccounts(Account accountFromTransfer) {
        LOGGER.info("Choose id of account, you want to transfer money");
        List<Account> userAccountList = AccountService.getAllAccountsByUser(accountFromTransfer.getOwner());
        LOGGER.info("You accounts, please choose one");
        for (Account userAccount: userAccountList) {
            LOGGER.info(userAccount);
        }
        int idAccount = SCANNER.nextInt();
        Optional<Account> accountOptional = userAccountList.stream().filter( acc -> acc.getIdAccount() == idAccount).findFirst();
        if (accountOptional.isPresent()) {
            Account accountToTransfer = accountOptional.get();
            LOGGER.info("The chosen account is " + accountToTransfer);
            transferMoney(accountFromTransfer, accountToTransfer);
        } else {
            LOGGER.info("There is no such account");
            transferMoneyFromAccount(accountFromTransfer);
        }
    }

    public static void transferToAnyAccount(Account accountFromTransfer) {
        LOGGER.info("Choose id of account, you want to transfer money");
        List<Account> accountList = AccountService.getAllAccounts();
        for (Account account: accountList) {
            LOGGER.info(account);
        }
        int idAccount = SCANNER.nextInt();
        Optional<Account> accountOptional = accountList.stream().filter( acc -> acc.getIdAccount() == idAccount).findFirst();
        if (accountOptional.isPresent()) {
            Account accountToTransfer = accountOptional.get();
            LOGGER.info("The chosen account is " + accountToTransfer);
            transferMoney(accountFromTransfer, accountToTransfer);
        } else {
            LOGGER.info("There is no such account");
            transferMoneyFromAccount(accountFromTransfer);
        }
    }

    public static void transferMoney(Account start, Account end) {
        LOGGER.info("Choose what sum you want to transfer");
        double money = SCANNER.nextInt();
        start.setTotalSum(start.getTotalSum() - money);
        boolean start_update = AccountService.updateAmountOnAccount(start);
        double endMoney = Exchange.getExchangeAmount(start.getCurrency(), end.getCurrency(), money);
        end.setTotalSum(end.getTotalSum() + endMoney);
        boolean end_update = AccountService.updateAmountOnAccount(end);
        if (start_update && end_update) {
            LOGGER.info("Money were successfully transfer");
            getCheckOfOperation(start, money);
        } else {
            LOGGER.info("Money are not transfer, try again later");
        }
    }

    public static void getCheckOfOperation(Account account, double amount) {
        LOGGER.info("Do you want to print check");
        LOGGER.info("1. Yes");
        LOGGER.info("2. No");
        int point = SCANNER.nextInt();
        if (point == 1) {
            Check check = new Check(account.getOwner(), account, OPERATION_NAME, amount);
            AllChecksCollection.addToCheckList(check);
        }
    }
}
