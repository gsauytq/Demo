/**
 * @author 12432
 * @date 2023/05/26
 */
package com.example.demo.service.impl;

import com.example.demo.dao.IndexPageDataDAO;
import com.example.demo.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexPageServiceImpl implements IndexPageService {

    private final IndexPageDataDAO indexPageDataDAO;

    public IndexPageServiceImpl(IndexPageDataDAO indexPageDataDAO) {
        this.indexPageDataDAO = indexPageDataDAO;
    }

    @Override
    public int[] selectYearData() {
        int[] selectYearData = indexPageDataDAO.selectYearData();
        return selectYearData;
    }

    @Override
    public int[] selectMonthData() {
        int[] selectMonthData = indexPageDataDAO.selectMonthData();
        return selectMonthData;
    }

    @Override
    public int[] selectDayData() {
        int[] selectDayData = indexPageDataDAO.selectDayData();
        return selectDayData;
    }

    @Override
    public int selectSale() {
        int selectSale = indexPageDataDAO.selectSale();
        return selectSale;
    }

    @Override
    public int selectTotalNumberOfStores() {
        int selectTotalNumberOfStores = indexPageDataDAO.selectTotalNumberOfStores();
        return selectTotalNumberOfStores;
    }

    @Override
    public int selectTotalNumberOfOrders() {
        int selectTotalNumberOfOrders = indexPageDataDAO.selectTotalNumberOfOrders();
        return selectTotalNumberOfOrders;
    }

    @Override
    public int[] selectOperatingReceipt() {
        int[] selectOperatingReceipt = indexPageDataDAO.selectOperatingReceipt();
        return selectOperatingReceipt;
    }
}
