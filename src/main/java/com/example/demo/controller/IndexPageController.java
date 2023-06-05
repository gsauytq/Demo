/**
 * @author 12432
 * @date 2023/05/26
 */
package com.example.demo.controller;

import com.example.demo.service.IndexPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index-page")
public class IndexPageController {

    private final IndexPageService indexPageService;

    public IndexPageController(IndexPageService indexPageService) {
        this.indexPageService = indexPageService;
    }

    @GetMapping("/year-visits")
    public int[] selectYearData() {
        int[] selectYearData = indexPageService.selectYearData();
        return selectYearData;
    }

    @GetMapping("/month-visits")
    public int[] selectMonthData() {
        int[] selectMonthData = indexPageService.selectMonthData();
        return selectMonthData;
    }

    @GetMapping("/day-visits")
    public int[] selectDayData() {
        int[] selectDayData = indexPageService.selectDayData();
        return selectDayData;
    }

    @GetMapping("/sale")
    public int selectSale() {
        int selectSale = indexPageService.selectSale();
        return selectSale;
    }

    @GetMapping("/total-stores")
    public int selectTotalStores() {
        int selectTotalNumberOfStores = indexPageService.selectTotalNumberOfStores();
        return selectTotalNumberOfStores;
    }

    @GetMapping("/total-orders")
    public int selectTotalOrders() {
        int selectTotalNumberOfOrders = indexPageService.selectTotalNumberOfOrders();
        return selectTotalNumberOfOrders;
    }

    @GetMapping("/operating_receipt")
    public int[] selectOperatingReceipt() {
        int[] selectOperatingReceipt = indexPageService.selectOperatingReceipt();
        return selectOperatingReceipt;
    }
}
