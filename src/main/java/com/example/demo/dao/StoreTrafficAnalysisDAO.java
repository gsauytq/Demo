package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StoreTrafficAnalysisDAO {

    @Select("select visits from store_annual_visits where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] storeYearVisitsData(String storeName);

    @Select("select visits from store_monthly_visits where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] storeMonthVisitsData(String storeName);

    @Select("select visits from store_daily_visits where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] storeDayVisitsData(String storeName);

    @Select("select traffic from consumer_traffic_gender_visits where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] consumerGenderData(String storeName);

    @Select("select traffic from consumer_traffic_expenditure_visits where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] consumerExpenditureData(String storeName);

    @Select("select traffic from consumer_traffic_type_visits where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] consumerTypeData(String storeName);

    @Select("select type from consumer_traffic_type_visits where store_id in (select store_id from store_list where store_name = #{storeName});")
    String[] consumerType(String storeName);

    @Select("select income from store_income_and_expenses where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] incomeData(String storeName);

    @Select("select expenses from store_income_and_expenses where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] expensesData(String storeName);

    @Select("select sale from store_activity_sale where store_id in (select store_id from store_list where store_name = #{storeName});")
    int[] storeActivityData(String storeName);
}
