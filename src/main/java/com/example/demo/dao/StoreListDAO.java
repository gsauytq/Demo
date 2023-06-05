package com.example.demo.dao;

import com.example.demo.dto.Store;
import com.example.demo.pojo.StoreList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 12432
 */
@Mapper
@Repository
public interface StoreListDAO {

    @Insert("insert into store_list(store_id, store_name, shopkeeper, create_time, status, description, phone)" +
            " values (0, #{storeName}, #{shopkeeper}, date(sysdate()), #{status}, #{description}, #{phone});")
    int insert(StoreList store);

    @Delete("delete from store_list where store_id = #{id};")
    int delete(int id);

    @Update("update store_list" +
            " set store_name = #{storeName}, shopkeeper = #{shopkeeper}, status = #{status}, description = #{description}, phone = #{phone}" +
            " where store_id = #{storeId};")
    int update(StoreList store);

    @Select("<script>"
            + "select store_id, store_name, shopkeeper, create_time, status, description, phone "
            + "from store_list_view "
            + "<where> "
            + "store_name = #{storeName} "
            + "<if test='shopkeeper != null and shopkeeper != \"\"'> "
            + "and shopkeeper = #{shopkeeper} "
            + "</if> "
            + "<if test='status != null and status != \"\"'> "
            + "and status = #{status} "
            + "</if> "
            + "<if test='phone != null and phone != \"\"'> "
            + "and phone = #{phone} "
            + "</if> "
            + "</where> "
            + "</script>")
    @Results({
            @Result(column = "store_id", property = "storeId"),
            @Result(column = "store_name", property = "storeName"),
            @Result(column = "create_time", property = "createTime")
    })
    StoreList selectByCondition(Store store);

    @Select("select store_id, store_name, shopkeeper, create_time, status, description, phone from store_list_view;")
    @Results({
            @Result(column = "store_id", property = "storeId"),
            @Result(column = "store_name", property = "storeName"),
            @Result(column = "create_time", property = "createTime")
    })
    List<StoreList> selectList();

    @Select("select store_id, store_name, shopkeeper, create_time, status, description, phone " +
            "from store_list_view " +
            "limit #{pageNo}, #{pageSize};")
    @Results({
            @Result(column = "store_id", property = "storeId"),
            @Result(column = "store_name", property = "storeName"),
            @Result(column = "create_time", property = "createTime")
    })
    List<StoreList> selectByPage(int pageNo, int pageSize);

    @Select("select count(1) from store_list;")
    int selectCount();
}
