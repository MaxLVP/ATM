package com.solvd.atm.services;

import com.solvd.atm.dao.IAccountDAO;
import com.solvd.atm.dao.mysql.AccountDAO;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;
import com.solvd.atm.models.User;

import java.util.List;

public class AccountService {
    private static final IAccountDAO ACCOUNT_DAO = new AccountDAO();


    public static List<Account> getAllAccounts() {
        return ACCOUNT_DAO.getAllAccounts();
    }

    public static Account getAccountByCard(Card card) {
        return ACCOUNT_DAO.getAccountByCardId(card.getId());
    }

    public static List<Account> getAllAccountsByUser(User user) {
        return ACCOUNT_DAO.getAllAccountsByUserId(user.getIdUser());
    }
}
