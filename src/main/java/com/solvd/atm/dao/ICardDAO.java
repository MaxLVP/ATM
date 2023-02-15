package com.solvd.atm.dao;

import com.solvd.atm.models.Card;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ICardDAO extends IBaseDAO<Card> {

    Card getEntityById(long id);

    @Select("SELECT id_card, number_card, validity, CVV, pin, account_id_account FROM card WHERE number_card = #{number_card}")
    @Results(value = {
            @Result(property = "idCard", column = "id_card"),
            @Result(property = "number", column = "number_card"),
            @Result(property = "validityDate", column = "validity"),
            @Result(property = "cvv", column = "CVV"),
            @Result(property = "pin", column = "pin")
    })
    Card getEntityByNumberCard(@Param("number_card") int number_card);
}
