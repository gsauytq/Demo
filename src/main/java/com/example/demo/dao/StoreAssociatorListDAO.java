package com.example.demo.dao;

import com.example.demo.dto.Associator;
import com.example.demo.pojo.StoreAssociator;
import com.example.demo.pojo.StoreList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreAssociatorListDAO {

    @Insert("insert into store_associator(associator_name, gender, age, phone, email, join_time, total, fk_organization) " +
            "values (#{associatorName}, #{gender}, #{age}, #{phone}, #{email}, date(sysdate()), 0, #{organization});")
    int insert(StoreAssociator storeAssociator);

    @Delete("delete from store_associator where associator_id = #{associatorId};")
    int delete(int associatorId);

    @Update("update store_associator " +
            "set associator_name = #{associatorName}, gender = #{gender}, age = #{age}, phone = #{phone}, email = #{email} " +
            "where associator_id = #{associatorId};")
    int update(StoreAssociator storeAssociator);

    @Select("<script>"
            + "select associator_id, associator_name, gender, age, phone, email, join_time, total, store_name "
            + "from store_associator_view "
            + "<where> "
            + "phone = #{phone} "
            + "<if test='associatorName != null and associatorName != \"\"'> "
            + "and associator_name = #{associatorName} "
            + "</if> "
            + "<if test='email != null and email != \"\"'> "
            + "and email = #{email} "
            + "</if> "
            + "</where> "
            + "</script>")
    @Results({
            @Result(column = "associator_id", property = "associatorId"),
            @Result(column = "associator_name", property = "associatorName"),
            @Result(column = "join_time", property = "joinTime"),
            @Result(column = "store_name", property = "organization")
    })
    StoreAssociator selectByCondition(Associator associator);

    @Select("select associator_id, associator_name, gender, age, phone, email, join_time, total, store_name " +
            "from store_associator_view;")
    @Results({
            @Result(column = "associator_id", property = "associatorId"),
            @Result(column = "associator_name", property = "associatorName"),
            @Result(column = "join_time", property = "joinTime"),
            @Result(column = "store_name", property = "organization")
    })
    List<StoreAssociator> selectList();

    @Select("select associator_id, associator_name, gender, age, phone, email, join_time, total, store_name " +
            "from store_associator_view limit #{pageNo}, #{pageSize};")
    @Results({
            @Result(column = "associator_id", property = "associatorId"),
            @Result(column = "associator_name", property = "associatorName"),
            @Result(column = "join_time", property = "joinTime"),
            @Result(column = "store_name", property = "organization")
    })
    List<StoreAssociator> selectByPage(int pageNo, int pageSize);

    @Select("select count(1) from store_associator_view;")
    int selectCount();
}
