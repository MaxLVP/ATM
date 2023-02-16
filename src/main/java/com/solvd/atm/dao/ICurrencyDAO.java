package com.solvd.atm.dao;

import com.solvd.atm.models.Currency;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ICurrencyDAO extends IBaseDAO<Currency> {
    @Select("SELECT course, id_currency FROM currency WHERE currency_name = #{currency_name}")
    @Results(value = {
            @Result(property = "idCurrency", column = "id_currency"),
            @Result(property = "course", column = "course")
    })
    Currency getEntityByCurrencyName(@Param("currency_name") String nameCurrency);

}
