package com.example.demo.dao;

import com.example.demo.dto.Commodity;
import com.example.demo.pojo.CommodityList;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 12432
 */
@Mapper
@Repository
public interface CommodityListDAO {

    @Insert("insert into commodity_list(commodity_name, yieldly, brand, production_enterprises, cost_price, price, description, stock)" +
            " values (#{commodityName}, #{yieldly}, #{brand}, #{productionEnterprises}, #{costPrice}, #{price}, #{description}, #{stock});")
    int insert(CommodityList commodity);

    @Delete("delete from commodity_list where commodity_id = #{id};")
    int delete(int id);

    @Update("update commodity_list" +
            " set commodity_name = #{commodityName}, yieldly = #{yieldly}, brand = #{brand}, production_enterprises = #{productionEnterprises}, cost_price = #{costPrice}, price = #{price}, description = #{description}, stock = #{stock}" +
            " where commodity_id = #{commodityId};")
    int update(CommodityList commodity);

    @Select("<script>"
            + "select commodity_id, commodity_id, commodity_name, yieldly, brand, production_enterprises, cost_price, price, description, stock "
            + "from commodity_list "
            + "<where> "
            + "commodity_name = #{commodityName} "
            + "<if test='brand != null and brand != \"\"'> "
            + "and brand = #{brand} "
            + "</if> "
            + "<if test='productionEnterprises != null and productionEnterprises != \"\"'> "
            + "and production_enterprises = #{productionEnterprises} "
            + "</if> "
            + "<if test='yieldly != null and yieldly != \"\"'> "
            + "and yieldly = #{yieldly} "
            + "</if> "
            + "</where> "
            + "</script>")
    @Results({
            @Result(column = "commodity_id", property = "commodityId"),
            @Result(column = "commodity_name", property = "commodityName"),
            @Result(column = "production_enterprises", property = "productionEnterprises"),
            @Result(column = "cost_price", property = "costPrice")
    })
    CommodityList selectByCondition(Commodity commodity);

    @Select("select commodity_id, commodity_id, commodity_name, yieldly, brand, production_enterprises, cost_price, price, description, stock" +
            " from commodity_list;")
    @Results({
            @Result(column = "commodity_id", property = "commodityId"),
            @Result(column = "commodity_name", property = "commodityName"),
            @Result(column = "production_enterprises", property = "productionEnterprises"),
            @Result(column = "cost_price", property = "costPrice")
    })
    List<CommodityList> selectList();

    @Select("select commodity_id, commodity_id, commodity_name, yieldly, brand, production_enterprises, cost_price, price, description, stock" +
            " from commodity_list" +
            " limit #{page}, #{size};")
    @Results({
            @Result(column = "commodity_id", property = "commodityId"),
            @Result(column = "commodity_name", property = "commodityName"),
            @Result(column = "production_enterprises", property = "productionEnterprises"),
            @Result(column = "cost_price", property = "costPrice")
    })
    List<CommodityList> selectByPage(int page, int size);

    @Select("select count(1) from commodity_list;")
    int selectCount();
}
