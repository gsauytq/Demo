/**
 * @author 12432
 * @date 2023/05/17
 */
package com.example.demo.controller;

import com.example.demo.dto.Administrator;
import com.example.demo.pojo.MallAdministrators;
import com.example.demo.pojo.StoreAdministrators;
import com.example.demo.service.AdministratorsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorsController {

    private final AdministratorsService administratorsService;

    public AdministratorsController(AdministratorsService administratorsService) {
        this.administratorsService = administratorsService;
    }

    @GetMapping("/mall-administrators")
    public List<MallAdministrators> selectAll() {
        return administratorsService.selectAll();
    }

    @GetMapping("/mall-administrators/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<MallAdministrators> data = administratorsService.selectMallAdministratorListByPage(page, size);
        Integer total = administratorsService.selectMallAdministratorsCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }

    @PostMapping("/mall-administrators/insert")
    public boolean insertMallAdministrators(@RequestBody MallAdministrators mallAdministrators) {
        boolean insertMallAdministrators = administratorsService.insertMallAdministrators(mallAdministrators);
        return insertMallAdministrators;
    }

    @DeleteMapping("/mall-administrators/delete/{administratorsId}")
    public boolean deleteMallAdministrators(@PathVariable Integer administratorsId) {
        boolean deleteMallAdministrators = administratorsService.deleteMallAdministrators(administratorsId);
        return deleteMallAdministrators;
    }

    @PutMapping("/mall-administrators/update")
    public boolean updateMallAdministrators(@RequestBody MallAdministrators mallAdministrators) {
        boolean updateMallAdministrators = administratorsService.updateMallAdministrators(mallAdministrators);
        return updateMallAdministrators;
    }

    @PostMapping("/mall-administrators/condition")
    public MallAdministrators selectMallAdministratorsByCondition(@RequestBody Administrator mall) {
        MallAdministrators mallAdministrators = administratorsService.selectMallAdministratorsByCondition(mall);
        return mallAdministrators;
    }

    @GetMapping("/store-administrators")
    public List<StoreAdministrators> selectStoreAll() {
        List<StoreAdministrators> storeAdministrators = administratorsService.selectStoreAll();
        return storeAdministrators;
    }

    @GetMapping("/store-administrators/page")
    public HashMap<String, Object> selectStoreAdministratorListByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<StoreAdministrators> data = administratorsService.selectStoreAdministratorListByPage(page, size);
        Integer total = administratorsService.selectStoreAdministratorsCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }

    @PostMapping("/store-administrators")
    public boolean insertStoreAdministrators(@RequestBody StoreAdministrators storeAdministrators) {
        boolean insert = administratorsService.insertStoreAdministrators(storeAdministrators);
        return insert;
    }

    @DeleteMapping("/store-administrators/delete/{id}")
    public boolean deleteStoreAdministrators(@PathVariable Integer id) {
        boolean delete = administratorsService.deleteStoreAdministrators(id);
        return delete;
    }

    @PutMapping("/store-administrators")
    public boolean updateStoreAdministrators(@RequestBody StoreAdministrators storeAdministrators) {
        boolean update = administratorsService.updateStoreAdministrators(storeAdministrators);
        return update;
    }

    @PostMapping("/store-administrators/condition")
    public StoreAdministrators selectStoreAdministratorsByCondition(@RequestBody Administrator storeAdministrator) {
        StoreAdministrators storeAdministrators = administratorsService.selectStoreAdministratorsByCondition(storeAdministrator);
        return storeAdministrators;
    }
}
