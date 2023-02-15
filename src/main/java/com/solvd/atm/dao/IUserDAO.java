package com.solvd.atm.dao;

import com.solvd.atm.models.User;
import org.apache.ibatis.annotations.*;

public interface IUserDAO extends IBaseDAO<User> {
    @Select("SELECT * FROM users WHERE id_user = #{id_user}")
    @Results(value = {
            @Result(property = "idUser", column = "id_user"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "passportID", column = "passport_ID")
    })
    User getEntityById(long id);

    @Update("UPDATE users SET first_name = #{first_name}, last_name = #{last_name}, passport_ID = #{passport_ID} " +
            "WHERE id_user = #{id_user}")
    boolean updateEntity(@Param("id_user") long id_user, @Param("first_name") String first_name,
                         @Param("last_name") String last_name, @Param("passport_ID") int passport_ID);

    @Insert("INSERT INTO users (first_name, last_name, passport_ID) VALUES (#{firstName}, #{lastName}, #{passportID})")
    @Options(useGeneratedKeys = true, keyProperty = "id_user")
    User createEntity(User entity);
    @Delete("DELETE FROM users WHERE id_user = #{id_user}")
    boolean removeEntity(@Param("id_user") long id);
}
