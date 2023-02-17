package com.solvd.atm.atm_menu.working_with_card;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Check;
import com.solvd.atm.models.Fine;
import com.solvd.atm.services.AccountService;
import com.solvd.atm.services.FineService;
import com.solvd.atm.utils.MyLogger;
import com.solvd.atm.utils.collections.AllChecksCollection;
import com.solvd.atm.utils.exchange.Exchange;
import com.solvd.atm.utils.parsers.JsonParser;

import java.util.Scanner;

public class BillsMenu {
    private static final MyLogger LOGGER = MyLogger.getInstance();
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void payBills(Account account) {
        LOGGER.info("Select the section for bill payment");
        LOGGER.info("1. Top up phone balance");
        LOGGER.info("2. Pay for the internet");
        LOGGER.info("3. Payment of fines");
        int chooseBillType = SCANNER.nextInt();
        switch (chooseBillType) {
            case 1 -> topUpPhoneBalance(account);
            case 2 -> payForTheInternet(account);
            case 3 -> payForFines(account);
        }
    }

    private static void topUpPhoneBalance(Account account) {
        LOGGER.info("Enter phone number");
        String phoneNumber = SCANNER.next();
        LOGGER.info("Enter amount, that you want to top up your balance");
        double amount = Double.parseDouble(SCANNER.next());
        LOGGER.info("Please, make sure that everything entered correctly:");
        LOGGER.info("Phone number: " + phoneNumber);
        LOGGER.info("Amount: " + amount);
        LOGGER.info("1 - pay");
        LOGGER.info("0 - cancel");
        int action = SCANNER.nextInt();
        if (action == 1) {
            if (account.getTotalSum() >= amount) {
                account = AccountService.transferMoney(account, amount);
                LOGGER.info("Print check?");
                LOGGER.info("1 - Yes");
                LOGGER.info("0 - No");
                int isPrint = SCANNER.nextInt();
                if (isPrint == 1) {
                    Check check = new Check
                            (account.getOwner(), account, "TOP UP PHONE BALANCE", amount);
                    LOGGER.info(check);
                    AllChecksCollection.addToCheckList(check);

                } else {
                    LOGGER.info("Your current account balance: " + account.getTotalSum() + " " + account.getCurrency());
                }
            } else {
                LOGGER.info("There are not enough money");
            }
        } else {
            LOGGER.info("Payment canceled");
        }
    }

    private static void payForTheInternet(Account account) {
        LOGGER.info("Enter contract number");
        String contractNumber = SCANNER.next();
        LOGGER.info("Enter amount, that you want to pay");
        double amount = Double.parseDouble(SCANNER.next());
        LOGGER.info("Please, make sure that everything entered correctly:");
        LOGGER.info("Contract number: " + contractNumber);
        LOGGER.info("Amount: " + amount);
        LOGGER.info("1 - pay");
        LOGGER.info("0 - cancel");
        int action = SCANNER.nextInt();
        if (action == 1) {
            if (account.getTotalSum() >= amount) {
                account = AccountService.transferMoney(account, amount);
                LOGGER.info("Print check?");
                LOGGER.info("1 - Yes");
                LOGGER.info("0 - No");
                int isPrint = SCANNER.nextInt();
                if (isPrint == 1) {
                    Check check = new Check
                            (account.getOwner(), account, "INTERNET PAYMENT", amount);
                    LOGGER.info(check);
                    AllChecksCollection.addToCheckList(check);

                } else {
                    LOGGER.info("Your current account balance: " + account.getTotalSum() + " " + account.getCurrency());
                }
            } else {
                LOGGER.info("There are not enough money");
            }
        } else {
            LOGGER.info("Payment canceled");
        }
    }

    private static void payForFines(Account account) {
        LOGGER.info("Enter resolution number");
        int resolutionNumber = SCANNER.nextInt();
        Fine fine = FineService.getFine(resolutionNumber);
        LOGGER.info(fine);
        if (fine != null) {
            LOGGER.info("Information about your fine");
            LOGGER.info("Reason for the fine: " + fine.getNameFine());
            LOGGER.info("Amount that you must pay: " + fine.getFineAmount() + " " + fine.getNameCurrency());
            LOGGER.info("Your current balance: " + account.getTotalSum() + " " + account.getCurrency());
            LOGGER.info("Choose action\n\n");
            LOGGER.info("1 - pay");
            LOGGER.info("0 - cancel");
            int action = SCANNER.nextInt();
            if (action == 1) {
                if (account.getTotalSum() >= fine.getFineAmount()) {
                    account = AccountService.transferMoney(account, Exchange.getExchangeAmount(account.getCurrency(),
                            fine.getNameCurrency(), fine.getFineAmount()));
                    LOGGER.info("Print check?");
                    LOGGER.info("1 - Yes");
                    LOGGER.info("0 - No");
                    int isPrint = SCANNER.nextInt();
                    if (isPrint == 1) {
                        Check check = new Check
                                (account.getOwner(), account, "FINES PAYMENT", fine.getFineAmount());
                        LOGGER.info(check);
                        AllChecksCollection.addToCheckList(check);

                    } else {
                        LOGGER.info("Your current account balance: " + account.getTotalSum() + " " + account.getCurrency());
                    }
                } else {
                    LOGGER.info("There are not enough money");
                }
            } else {
                LOGGER.info("Payment canceled");
            }
        } else {
            LOGGER.info("Sorry, fine was not found");
        }
    }
}
