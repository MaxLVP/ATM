package com.solvd.atm.services;

import com.solvd.atm.dao.IAccountDAO;
import com.solvd.atm.dao.IUserDAO;
import com.solvd.atm.dao.mysql.AccountDAO;
import com.solvd.atm.dao.mysql.UserDAO;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.Card;
import com.solvd.atm.models.User;

import java.util.List;

public class AccountService {
    private static final IAccountDAO ACCOUNT_DAO = new AccountDAO();
    private static final IUserDAO USER_DAO = new UserDAO();


    public static List<Account> getAllAccounts() {
        List<Account> accountList = ACCOUNT_DAO.getAllAccounts();
        for (Account account : accountList) {
            account.setOwner(USER_DAO.getEntityByAccountId(account.getIdAccount()));
        }
        return ACCOUNT_DAO.getAllAccounts();
    }

    public static Account getAccountByCard(Card card) {
        Account account = ACCOUNT_DAO.getAccountByCardId(card.getId());
        if (account != null) {
            account.setOwner(USER_DAO.getEntityByAccountId(account.getIdAccount()));
            return account;
        } else {
            return null;
        }
    }

    public static List<Account> getAllAccountsByUser(User user) {
        List<Account> accountList = ACCOUNT_DAO.getAllAccountsByUserId(user.getIdUser());
        for (Account account : accountList) {
            account.setOwner(USER_DAO.getEntityByAccountId(account.getIdAccount()));
        }
        return ACCOUNT_DAO.getAllAccountsByUserId(user.getIdUser());
    }

    public static boolean updateAmountOnAccount(Account account) {
        return ACCOUNT_DAO.updateEntity(account.getTotalSum(), account.getIdAccount());
    }

    public static Account transferMoney(Account account, double amount) {
        account.setTotalSum(account.getTotalSum() - amount);
        ACCOUNT_DAO.updateEntity(account.getTotalSum(), account.getIdAccount());
        return account;
    }
}
