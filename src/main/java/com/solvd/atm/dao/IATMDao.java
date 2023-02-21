package com.solvd.atm.dao;

import com.solvd.atm.models.ATM;
import com.solvd.atm.models.Bill;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IATMDao extends IBaseDAO<ATM> {
    @Select("SELECT idATM, ATMname FROM atm WHERE idATM = #{idATM}")
    @Results(value = {
            @Result(property = "id", column = "b.idATM"),
            @Result(property = "name", column = "b.ATMname")
    })
    ATM getEntityById(@Param("idATM") long idATM);

    @Update("UPDATE atm SET ATMname = #{ATMname} WHERE idATM = #{idATM}")
    boolean updateEntity(@Param("ATMname") String atmName, @Param("idATM") long idATM);

//    @Insert("INSERT INTO banknote (id_banknote, name_banknote, currency_id_currency, banknote_count) VALUES " +
//            "(#{id_banknote}, #{name_banknote}, #{currency_id_currency}, #{banknote_count})")
//    Account createEntity(@Param("id_banknote") long id_banknote, @Param("name_banknote") String name_banknote,
//                         @Param("currency_id_currency") int amount, @Param("banknote_count") int banknote_count);
//
//    @Delete("DELETE FROM banknote WHERE id_banknote = #{id_banknote}")
//    boolean removeEntity(@Param("id_banknote") long id_banknote);

    @Select("SELECT idATM, ATMname FROM atm")
    @Results(value = {
            @Result(property = "id", column = "b.idATM"),
            @Result(property = "name", column = "b.ATMname")
    })
    List<ATM> getAllATMs();
}
