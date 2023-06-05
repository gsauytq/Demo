/**
 * @author 12432
 * @date 2023/05/29
 */
package com.example.demo.service.impl;

import com.example.demo.dao.StoreTrafficAnalysisDAO;
import com.example.demo.service.StoreTrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreTrafficServiceImpl implements StoreTrafficService {

    private final StoreTrafficAnalysisDAO storeTrafficAnalysisDAO;

    public StoreTrafficServiceImpl(StoreTrafficAnalysisDAO storeTrafficAnalysisDAO) {
        this.storeTrafficAnalysisDAO = storeTrafficAnalysisDAO;
    }

    @Override
    public int[] storeYearVisitsData(String storeName) {
        int[] storeYearVisitsData = storeTrafficAnalysisDAO.storeYearVisitsData(storeName);
        return storeYearVisitsData;
    }

    @Override
    public int[] storeMonthVisitsData(String storeName) {
        int[] storeMonthVisitsData = storeTrafficAnalysisDAO.storeMonthVisitsData(storeName);
        return storeMonthVisitsData;
    }

    @Override
    public int[] storeDayVisitsData(String storeName) {
        int[] storeDayVisitsData = storeTrafficAnalysisDAO.storeDayVisitsData(storeName);
        return storeDayVisitsData;
    }

    @Override
    public int[] consumerGenderData(String storeName) {
        int[] consumerGenderData = storeTrafficAnalysisDAO.consumerGenderData(storeName);
        return consumerGenderData;
    }

    @Override
    public int[] consumerExpenditureData(String storeName) {
        int[] consumerExpenditureData = storeTrafficAnalysisDAO.consumerExpenditureData(storeName);
        return consumerExpenditureData;
    }

    @Override
    public int[] consumerTypeData(String storeName) {
        int[] consumerTypeData = storeTrafficAnalysisDAO.consumerTypeData(storeName);
        return consumerTypeData;
    }

    @Override
    public String[] consumerType(String storeName) {
        String[] consumerType = storeTrafficAnalysisDAO.consumerType(storeName);
        return consumerType;
    }

    @Override
    public int[] incomeData(String storeName) {
        int[] incomeData = storeTrafficAnalysisDAO.incomeData(storeName);
        return incomeData;
    }

    @Override
    public int[] expensesData(String storeName) {
        int[] expensesData = storeTrafficAnalysisDAO.expensesData(storeName);
        return expensesData;
    }

    @Override
    public int[] storeActivityData(String storeName) {
        int[] storeActivityData = storeTrafficAnalysisDAO.storeActivityData(storeName);
        return storeActivityData;
    }
}
