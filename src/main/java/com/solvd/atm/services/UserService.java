package com.solvd.atm.services;

import com.solvd.atm.dao.IUserDAO;
import com.solvd.atm.dao.mysql.UserDAO;
import com.solvd.atm.models.Account;
import com.solvd.atm.models.User;

public class UserService {
    private static final IUserDAO USER_DAO = new UserDAO();

    public static User getUserByAccountID(Account account) {
        return USER_DAO.getEntityByAccountId(account.getIdAccount());
    }
}
