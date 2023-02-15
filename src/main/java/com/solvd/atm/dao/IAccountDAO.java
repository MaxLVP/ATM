package com.solvd.atm.dao;

import com.solvd.atm.models.Account;

import java.util.List;

public interface IAccountDAO extends IBaseDAO<Account> {

    List<Account> getAllAccounts();

    Account getAccountByCardId(long id);
}
