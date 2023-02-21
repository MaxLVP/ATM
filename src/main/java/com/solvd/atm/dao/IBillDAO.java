package com.solvd.atm.dao;

import com.solvd.atm.models.Account;
import com.solvd.atm.models.Bill;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface IBillDAO extends IBaseDAO<Bill> {
    @Select("SELECT b.id_banknote, b.name_banknote, b.banknote_count, c.currency_name FROM banknote b " +
            "JOIN currency c ON banknote.currency_id_currency = currency.id_currency WHERE id_banknote = #{id_banknote}")
    @Results(value = {
            @Result(property = "idBill", column = "b.id_banknote"),
            @Result(property = "rating", column = "b.name_banknote"),
            @Result(property = "currency", column = "c.currency_name"),        //fix string and int
            @Result(property = "count", column = "b.banknote_count")
    })
    Bill getEntityById(@Param("id_banknote") long id_banknote);
    @Update("UPDATE banknote SET banknote_count = #{banknote_count} WHERE id_banknote = #{id_banknote}")
    boolean updateEntity(@Param("id_banknote") long id_banknote, @Param("banknote_count") int banknote_count);
//    @Insert("INSERT INTO banknote (id_banknote, name_banknote, currency_id_currency, banknote_count) VALUES " +
//            "(#{id_banknote}, #{name_banknote}, #{currency_id_currency}, #{banknote_count})")
//    Account createEntity(@Param("id_banknote") long id_banknote, @Param("name_banknote") String name_banknote,
//                         @Param("currency_id_currency") int amount, @Param("banknote_count") int banknote_count);
//
//    @Delete("DELETE FROM banknote WHERE id_banknote = #{id_banknote}")
//    boolean removeEntity(@Param("id_banknote") long id_banknote);

    @Select("SELECT id_banknote, name_banknote, banknote_count, currency_id_currency, ATM_idATM FROM banknote")
    @Results(value = {
            @Result(property = "idBill", column = "id_banknote"),
            @Result(property = "rating", column = "name_banknote"),
            @Result(property = "idCurr", column = "currency_id_currency"),
            @Result(property = "count", column = "banknote_count"),
            @Result(property = "idATM", column = "ATM_idATM")
    })
    List<Bill> getAllBills();

    @Select("SELECT id_banknote, name_banknote, banknote_count, currency_id_currency, ATM_idATM FROM banknote " +
            "WHERE banknote.ATM_idATM = #{idATM}")
    @Results(value = {
            @Result(property = "idBill", column = "id_banknote"),
            @Result(property = "rating", column = "name_banknote"),
            @Result(property = "idCurr", column = "currency_id_currency"),
            @Result(property = "count", column = "banknote_count"),
            @Result(property = "idATM", column = "ATM_idATM")
    })
    List<Bill> getBillsByAtmId(@Param("idATM") long idATM);
}
