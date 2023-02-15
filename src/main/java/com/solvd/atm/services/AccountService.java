package com.solvd.atm.services;

import com.solvd.atm.dao.IAccountDAO;
import com.solvd.atm.dao.mysql.AccountDAO;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;

import java.util.List;

public class AccountService {
    private static final IAccountDAO ACCOUNT_DAO = new AccountDAO();


    public static List<Account> getAllAccounts() {
        List<Account> accountList = ACCOUNT_DAO.getAllAccounts();
        return accountList;
    }

    public static Account getAccountByCard(Card card) {
        Account account = ACCOUNT_DAO.getAccountByCardId(card.getId());
        return account;
    }
}
