package com.example.demo.dao;

import com.example.demo.dto.Associator;
import com.example.demo.pojo.MallAssociator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MallAssociatorListDAO {

    @Insert("insert into mall_associator(associator_id, associator_name, gender, age, phone, email, join_time, total) " +
            "values (0, #{associatorName}, #{gender}, #{age}, #{phone}, #{email}, date(sysdate()), 0);")
    int insert(MallAssociator associator);

    @Delete("delete from mall_associator where associator_id = #{id}")
    int delete(int id);

    @Update("update mall_associator " +
            "set associator_name = #{associatorName}, gender = #{gender}, age = #{age}, phone = #{phone}, email = #{email} where associator_id = #{associatorId};")
    int update(MallAssociator associator);

    @Select("<script>"
            + "select associator_id, associator_name, gender, age, phone, email, join_time, total "
            + "from mall_associator "
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
            @Result(column = "join_time", property = "joinTime")
    })
    MallAssociator selectByConditon(Associator mallAssociator);

    @Select("select associator_id, associator_name, gender, age, phone, email, join_time, total from mall_associator;")
    @Results({
            @Result(column = "associator_id", property = "associatorId"),
            @Result(column = "associator_name", property = "associatorName"),
            @Result(column = "join_time", property = "joinTime")
    })
    List<MallAssociator> selectList();

    @Select("select associator_id, associator_name, gender, age, phone, email, join_time, total from mall_associator limit #{page}, #{size};")
    @Results({
            @Result(column = "associator_id", property = "associatorId"),
            @Result(column = "associator_name", property = "associatorName"),
            @Result(column = "join_time", property = "joinTime")
    })
    List<MallAssociator> selectByPage(int page, int size);

    @Select("select count(1) from mall_associator;")
    int selectCount();
}
