package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IAccountDAO;
import com.solvd.atm.dao.utils.MyBatisDAO;
import com.solvd.atm.models.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;

import java.util.List;

public class AccountDAO implements IAccountDAO {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDAO.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final IAccountDAO iAccountDAO = sqlSession.getMapper(IAccountDAO.class);

    @Override
    public Account createEntity(long id_account, Date opening_date, double amount, String name_currency, long id_user) {
        return null;
    }

    @Override
    public Account getEntityById(long id) {
        return iAccountDAO.getEntityById(id);
    }

    @Override
    public boolean updateEntity(long id_account) {
        return false;
    }

    @Override
    public boolean updateEntity(Account entity) {
        return false;
    }

    @Override
    public Account createEntity(Account entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public Account getAccountByCardId(long id) {
        return null;
    }
}
