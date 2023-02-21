package com.solvd.atm.dao.mysql;

import com.solvd.atm.dao.IATMDao;
import com.solvd.atm.dao.utils.MyBatisDAO;
import com.solvd.atm.models.ATM;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ATMDao implements IATMDao {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDAO.getSqlSessionFactory();
    private final SqlSession sqlSession = SESSION_FACTORY.openSession();
    private final IATMDao iatmDao = sqlSession.getMapper(IATMDao.class);

    @Override
    public ATM getEntityById(long idATM) {
        return iatmDao.getEntityById(idATM);
    }

    @Override
    public boolean updateEntity(String atmName, long idATM) {
        return iatmDao.updateEntity(atmName, idATM);
    }

    @Override
    public List<ATM> getAllATMs() {
        return iatmDao.getAllATMs();
    }

    @Override
    public boolean updateEntity(ATM entity) {
        return iatmDao.updateEntity(entity);
    }

    @Override
    public ATM createEntity(ATM entity) {
        return iatmDao.createEntity(entity);
    }

    @Override
    public boolean removeEntity(long id) {
        return iatmDao.removeEntity(id);
    }
}
