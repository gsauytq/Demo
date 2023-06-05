/**
 * @author 12432
 * @date 2023/05/29
 */
package com.example.demo.controller;

import com.example.demo.service.StoreTrafficService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store-traffic")
public class StoreTrafficController {

    private final StoreTrafficService storeTrafficService;

    public StoreTrafficController(StoreTrafficService storeTrafficService) {
        this.storeTrafficService = storeTrafficService;
    }

    @GetMapping("/store-year-visits")
    public int[] storeYearVisitsData(@RequestParam String storeName) {
        int[] storeYearVisitsData = storeTrafficService.storeYearVisitsData(storeName);
        return storeYearVisitsData;
    }

    @GetMapping("/store-month-visits")
    public int[] storeMonthVisitsData(@RequestParam String storeName) {
        int[] storeMonthVisitsData = storeTrafficService.storeMonthVisitsData(storeName);
        return storeMonthVisitsData;
    }

    @GetMapping("/store-day-visits")
    public int[] storeDayVisitsData(@RequestParam String storeName) {
        int[] storeDayVisitsData = storeTrafficService.storeDayVisitsData(storeName);
        return storeDayVisitsData;
    }

    @GetMapping("/consumer-gender-data")
    public int[] consumerGenderData(@RequestParam String storeName) {
        int[] consumerGenderData = storeTrafficService.consumerGenderData(storeName);
        return consumerGenderData;
    }

    @GetMapping("/consumer-expenditure-data")
    public int[] consumerExpenditureData(@RequestParam String storeName) {
        int[] consumerExpenditureData = storeTrafficService.consumerExpenditureData(storeName);
        return consumerExpenditureData;
    }

    @GetMapping("/consumer-type-data")
    public int[] consumerTypeData(@RequestParam String storeName) {
        int[] consumerTypeData = storeTrafficService.consumerTypeData(storeName);
        return consumerTypeData;
    }

    @GetMapping("/consumer-type")
    public String[] consumerType(@RequestParam String storeName) {
        String[] consumerType = storeTrafficService.consumerType(storeName);
        return consumerType;
    }

    @GetMapping("/income-data")
    public int[] incomeData(@RequestParam String storeName) {
        int[] incomeData = storeTrafficService.incomeData(storeName);
        return incomeData;
    }

    @GetMapping("/expenses-data")
    public int[] expensesData(@RequestParam String storeName) {
        int[] expensesData = storeTrafficService.expensesData(storeName);
        return expensesData;
    }

    @GetMapping("/store-activity-data")
    public int[] storeActivityData(@RequestParam String storeName) {
        int[] storeActivityData = storeTrafficService.storeActivityData(storeName);
        return storeActivityData;
    }
}
