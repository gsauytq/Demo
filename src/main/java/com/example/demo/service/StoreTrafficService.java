package com.example.demo.service;

import org.apache.ibatis.annotations.Select;

public interface StoreTrafficService {
    int[] storeYearVisitsData(String storeName);
    int[] storeMonthVisitsData(String storeName);
    int[] storeDayVisitsData(String storeName);
    int[] consumerGenderData(String storeName);
    int[] consumerExpenditureData(String storeName);
    int[] consumerTypeData(String storeName);
    String[] consumerType(String storeName);
    int[] incomeData(String storeName);
    int[] expensesData(String storeName);
    int[] storeActivityData(String storeName);
}
