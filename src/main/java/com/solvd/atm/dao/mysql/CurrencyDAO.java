package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.ICurrencyDAO;
import com.solvd.atm.dao.utils.MyBatisDAO;
import com.solvd.atm.models.Currency;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CurrencyDAO implements ICurrencyDAO {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDAO.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final ICurrencyDAO iCurrencyDAO = sqlSession.getMapper(ICurrencyDAO.class);

    @Override
    public Currency getEntityById(long id) {
        return null;
    }

    @Override
    public boolean updateEntity(Currency entity) {
        try {
            iCurrencyDAO.updateEntity(entity);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
        }
        return true;
    }

    @Override
    public List<Currency> getAllCurrency() {
        return iCurrencyDAO.getAllCurrency();
    }

    @Override
    public Currency createEntity(Currency entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }

    @Override
    public Currency getEntityByCurrencyName(String nameCurrency) {
        return iCurrencyDAO.getEntityByCurrencyName(nameCurrency);
    }
}
