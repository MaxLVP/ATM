package com.solvd.atm.dao;

import com.solvd.atm.models.Account;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface IAccountDAO extends IBaseDAO<Account> {
    @Select("SELECT id_account, opening_date, amount, name_currency FROM account WHERE id_account = #{id_account}")
    @Results(value = {
            @Result(property = "idAccount", column = "id_account"),
            @Result(property = "openingDate", column = "opening_date"),
            @Result(property = "currency", column = "name_currency"),
            @Result(property = "totalSum", column = "amount")
    })
    Account getEntityById(@Param("id_account") long id_account);

    @Update("UPDATE account SET amount = #{amount} WHERE id_account = #{id_account}")
    boolean updateEntity(@Param("amount") double amount, @Param("id_account") long id_account);

    @Insert("INSERT INTO account (id_account, opening_date, amount, name_currency, users_id_user) VALUES " +
            "(#{id_account}, #{opening_date}, #{amount}, #{name_currency}, #{id_user})")
    Account createEntity(@Param("id_account") long id_account, @Param("opening_date") Date opening_date,
                         @Param("amount") double amount, @Param("name_currency") String name_currency,
                         @Param("id_user") long id_user);

    @Delete("DELETE FROM account WHERE id_account = #{id_account}")
    boolean removeEntity(@Param("id_account") long id_account);

    @Select("SELECT id_account, opening_date, amount, name_currency FROM account")
    @Results(value = {
            @Result(property = "idAccount", column = "id_account"),
            @Result(property = "openingDate", column = "opening_date"),
            @Result(property = "currency", column = "name_currency"),
            @Result(property = "totalSum", column = "amount")
    })
    List<Account> getAllAccounts();

    @Select("SELECT id_account, opening_date, amount, name_currency FROM account LEFT JOIN card ON id_account=card.account_id_account WHERE id_card=#{id_card}")
    @Results(value = {
            @Result(property = "idAccount", column = "id_account"),
            @Result(property = "openingDate", column = "opening_date"),
            @Result(property = "currency", column = "name_currency"),
            @Result(property = "totalSum", column = "amount")
    })
    Account getAccountByCardId(@Param("id_card") long id);

    @Select("""
            SELECT id_account, opening_date, amount, name_currency
            FROM account
            LEFT JOIN users
            ON id_user = account.users_id_user
            WHERE id_user = #{id_user}""")
    @Results(value = {
            @Result(property = "idAccount", column = "id_account"),
            @Result(property = "openingDate", column = "opening_date"),
            @Result(property = "currency", column = "name_currency"),
            @Result(property = "totalSum", column = "amount")
    })
    List<Account> getAllAccountsByUserId(@Param("id_user") long id);
}