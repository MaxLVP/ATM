package com.solvd.atm.dao;

import com.solvd.atm.models.Currency;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICurrencyDAO extends IBaseDAO<Currency> {
    @Select("SELECT course, id_currency FROM currency WHERE currency_name = #{currency_name}")
    @Results(value = {
            @Result(property = "idCurrency", column = "id_currency"),
            @Result(property = "course", column = "course")
    })
    Currency getEntityByCurrencyName(@Param("currency_name") String nameCurrency);

    @Update("UPDATE currency SET course = #{course}")
    boolean updateEntity(Currency entity);

    @Select("SELECT course, id_currency, currency_name FROM currency")
    @Results(value = {
            @Result(property = "idCurrency", column = "id_currency"),
            @Result(property = "course", column = "course"),
            @Result(property = "name", column = "currency_name")
    })
    List<Currency> getAllCurrency();
}
