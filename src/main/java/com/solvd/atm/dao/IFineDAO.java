package com.solvd.atm.dao;

import com.solvd.atm.models.Fine;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface IFineDAO extends IBaseDAO<Fine> {
    @Select("SELECT * FROM fines WHERE id_fine = #{id_fine}")
    @Results(value = {
            @Result(property = "idFine", column = "id_fine"),
            @Result(property = "nameFine", column = "name_fine"),
            @Result(property = "fineAmount", column = "fine_amount"),
            @Result(property = "nameCurrency", column = "name_currency")
    })
    Fine getEntityById(@Param("id_fine") long id_fine);
}
