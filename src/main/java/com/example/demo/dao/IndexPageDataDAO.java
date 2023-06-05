package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IndexPageDataDAO {

    @Select("select visits from mall_annual_visits;")
    int[] selectYearData();

    @Select("select visits from mall_monthly_visits;")
    int[] selectMonthData();

    @Select("select visits from mall_daily_visits;")
    int[] selectDayData();

    @Select("select sale from mall_data_card;")
    int selectSale();

    @Select("select total_number_of_stores from mall_data_card;")
    int selectTotalNumberOfStores();

    @Select("select total_number_of_orders from mall_data_card;")
    int selectTotalNumberOfOrders();

    @Select("select operating_receipt from mall_operating_receipt;")
    int[] selectOperatingReceipt();
}
