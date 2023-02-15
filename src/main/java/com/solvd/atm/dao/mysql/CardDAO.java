package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.ICardDAO;
import com.solvd.atm.dao.utils.MyBatisDAO;
import com.solvd.atm.models.Card;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CardDAO implements ICardDAO {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDAO.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final ICardDAO iCardDAO = sqlSession.getMapper(ICardDAO.class);

    @Override
    public Card getEntityById(long id) {
        return null;
    }

    @Override
    public Card getEntityByNumberCard(int number_card) {
        return iCardDAO.getEntityByNumberCard(number_card);
    }

    @Override
    public boolean updateEntity(Card entity) {
        return false;
    }

    @Override
    public Card createEntity(Card entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }
}
