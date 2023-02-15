package com.solvd.atm.dao.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisDAO {
    private final static MyBatisDAO myBatisDao = new MyBatisDAO();
    private static SqlSessionFactory sqlSessionFactory;

    private MyBatisDAO() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-properties.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
