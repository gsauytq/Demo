package com.example.demo.dao;

import com.example.demo.dto.Administrator;
import com.example.demo.pojo.MallAdministrators;
import com.example.demo.pojo.StoreAdministrators;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorsDAO {

    @Select("select administrators_id, administrators_name, gender, age, create_time, email, phone from mall_administrators;")
    @Results({
            @Result(column = "administrators_id", property = "administratorsId"),
            @Result(column = "administrators_name", property = "administratorsName"),
            @Result(column = "create_time", property = "createTime")
    })
    List<MallAdministrators> selectAll();

    @Select("select administrators_id, administrators_name, gender, age, create_time, email, phone from mall_administrators" +
            " limit #{page}, #{size};")
    @Results({
            @Result(column = "administrators_id", property = "administratorsId"),
            @Result(column = "administrators_name", property = "administratorsName"),
            @Result(column = "create_time", property = "createTime")
    })
    List<MallAdministrators> selectMallAdministratorListByPage(int page, int size);

    @Select("select count(1) from mall_administrators;")
    int selectMallAdministratorsCount();

    @Insert("insert into mall_administrators(administrators_name, gender, age, create_time, email, phone) " +
            "values (#{administratorsName}, #{gender}, #{age}, date(sysdate()), #{email}, #{phone});")
    int insertMallAdministrators(MallAdministrators mall);

    @Delete("delete from mall_administrators where administrators_id = #{id};")
    int deleteMallAdministrators(int id);

    @Update("update mall_administrators " +
            "set administrators_name = #{administratorsName}, gender = #{gender}, age = #{age}, email = #{email}, phone = #{phone} " +
            "where administrators_id = #{administratorsId}")
    int updateMallAdministrators(MallAdministrators mall);

    @Select("<script>"
            + "select administrators_id, administrators_name, gender, age, create_time, email, phone "
            + "from mall_administrators "
            + "<where> "
            + "administrators_name = #{administratorsName} and phone = #{phone} "
            + "<if test='email != null and email != \"\"'> "
            + "and email = #{email} "
            + "</if> "
            + "</where> "
            + "</script>")
    @Results({
            @Result(column = "administrators_id", property = "administratorsId"),
            @Result(column = "administrators_name", property = "administratorsName"),
            @Result(column = "create_time", property = "createTime")
    })
    MallAdministrators selectMallAdministratorsByCondition(Administrator mall);


    @Select("select administrators_id, administrators_name, gender, age, create_time, email, phone, store_name" +
            " from store_administrators_view;")
    @Results({
            @Result(column = "administrators_id", property = "administratorsId"),
            @Result(column = "administrators_name", property = "administratorsName"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "store_name", property = "organization")
    })
    List<StoreAdministrators> selectStoreAll();

    @Select("select administrators_id, administrators_name, gender, age, create_time, email, phone, store_name" +
            " from store_administrators_view" +
            " limit #{page}, #{size};")
    @Results({
            @Result(column = "administrators_id", property = "administratorsId"),
            @Result(column = "administrators_name", property = "administratorsName"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "store_name", property = "organization")
    })
    List<StoreAdministrators> selectStoreAdministratorListByPage(int page, int size);

    @Select("select count(1) from store_administrators;")
    int selectStoreAdministratorsCount();

    @Insert("insert into store_administrators(administrators_name, gender, age, create_time, email, phone, organization) " +
            "values (#{administratorsName}, #{gender}, #{age}, date(sysdate()), #{email}, #{phone}, #{organization});")
    int insertStoreAdministrators(StoreAdministrators storeAdministrators);

    @Delete("delete from store_administrators where administrators_id = #{id};")
    int deleteStoreAdministrators(int id);

    @Update("update store_administrators " +
            "set administrators_name = #{administratorsName}, gender = #{gender}, age = #{age}, email = #{email}, phone = #{phone} " +
            "where administrators_id = #{administratorsId}")
    int updateStoreAdministrators(StoreAdministrators storeAdministrators);

    @Select("<script>"
            + "select administrators_id, administrators_name, gender, age, create_time, email, phone, store_name "
            + "from store_administrators_view "
            + "<where> "
            + "administrators_name = #{administratorsName} and phone = #{phone} "
            + "<if test='email != null and email != \"\"'> "
            + "and email = #{email} "
            + "</if> "
            + "</where> "
            + "</script>")
    @Results({
            @Result(column = "administrators_id", property = "administratorsId"),
            @Result(column = "administrators_name", property = "administratorsName"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "store_name", property = "organization")
    })
    StoreAdministrators selectStoreAdministratorsByCondition(Administrator storeAdministrator);
}
