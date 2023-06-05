package com.example.demo.service;

public interface IndexPageService {
    int[] selectYearData();
    int[] selectMonthData();
    int[] selectDayData();
    int selectSale();
    int selectTotalNumberOfStores();
    int selectTotalNumberOfOrders();
    int[] selectOperatingReceipt();
}
