package com.example.demo.dao;

import com.example.demo.dto.InOutNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StorageTrafficDAO {

    @Select("select incoming, outgoing from storage_incoming_and_outgoing_volumes where storage_id in (select storage_id from storage_list where storage_id = #{id});")
    InOutNumber[] inoutNumberData(int id);

    @Select("select traffic from storage_commodity_type_traffic where storage_id in (select storage_id from storage_list where storage_id = #{id});")
    int[] typeSaleData(int id);

    @Select("select type from storage_commodity_type_traffic where storage_id in (select storage_id from storage_list where storage_id = #{id});")
    String[] typeData(int id);
}
