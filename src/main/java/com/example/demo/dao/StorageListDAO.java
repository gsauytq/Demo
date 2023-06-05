package com.example.demo.dao;

import com.example.demo.dto.Storage;
import com.example.demo.pojo.StorageList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 12432
 */
@Mapper
@Repository
public interface StorageListDAO {

    @Insert("insert into storage_list(create_time, storage_volume, capacity_remaining, status, summary, storage_administrators)" +
            " values (date(sysdate()), #{storageVolume}, 0, #{status}, #{summary}, #{storageAdministrators});")
    int insert(StorageList storage);

    @Delete("delete from storage_list where storage_id = #{id};")
    int delete(int id);

    @Update("update storage_list" +
            " set storage_volume = #{storageVolume}, capacity_remaining = #{capacityRemaining}, status = #{status}, summary = #{summary}, storage_administrators = #{storageAdministrators}" +
            " where storage_id = #{storageId};")
    int update(StorageList storage);

    @Select("<script>"
            + "select storage_id, create_time, storage_volume, capacity_remaining, status, summary, storage_administrators "
            + "from storage_list_view "
            + "<where> "
            + "storage_id = #{storageId} "
            + "<if test='status != null and status != \"\"'> "
            + "and status = #{status} "
            + "</if> "
            + "<if test='storageAdministrators != null and storageAdministrators != \"\"'> "
            + "and administrators_name = #{storageAdministrators} "
            + "</if> "
            + "</where> "
            + "</script>")
    @Results({
            @Result(column = "storage_id", property = "storageId"),
            @Result(column = "storage_volume", property = "storageVolume"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "capacity_remaining", property = "capacityRemaining"),
            @Result(column = "administrators_name", property = "storageAdministrators")
    })
    StorageList selectByCondition(Storage storage);

    @Select("select storage_id, create_time, storage_volume, capacity_remaining, status, summary, administrators_name" +
            " from storage_list_view")
    @Results({
            @Result(column = "storage_id", property = "storageId"),
            @Result(column = "storage_volume", property = "storageVolume"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "capacity_remaining", property = "capacityRemaining"),
            @Result(column = "administrators_name", property = "storageAdministrators")
    })
    List<StorageList> selectList();

    @Select("select storage_id, create_time, storage_volume, capacity_remaining, status, summary, administrators_name " +
            "from storage_list_view " +
            "limit #{page}, #{size}")
    @Results({
            @Result(column = "storage_id", property = "storageId"),
            @Result(column = "storage_volume", property = "storageVolume"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "capacity_remaining", property = "capacityRemaining"),
            @Result(column = "administrators_name", property = "storageAdministrators")
    })
    List<StorageList> selectByPage(int page, int size);

    @Select("select count(1) from storage_list;")
    int selectCount();
}
