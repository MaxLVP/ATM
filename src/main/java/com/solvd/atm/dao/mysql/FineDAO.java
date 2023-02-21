package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IFineDAO;
import com.solvd.atm.dao.utils.MyBatisDAO;
import com.solvd.atm.models.Fine;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class FineDAO implements IFineDAO {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDAO.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final IFineDAO iFineDAO = sqlSession.getMapper(IFineDAO.class);

    @Override
    public Fine getEntityById(long id) {
        return iFineDAO.getEntityById(id);
    }

    @Override
    public boolean updateEntity(Fine entity) {
        return false;
    }

    @Override
    public Fine createEntity(Fine entity) {
        return null;
    }

    @Override
    public boolean removeEntity(long id) {
        return false;
    }
}
