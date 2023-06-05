/**
 * @author 12432
 * @date 2023/05/09
 */
package com.example.demo.controller;

import com.example.demo.dto.Store;
import com.example.demo.pojo.StoreList;
import com.example.demo.service.StoreListService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/store-list")
public class StoreListController {

    private final StoreListService storeListService;

    public StoreListController(StoreListService storeListService) {
        this.storeListService = storeListService;
    }

    @GetMapping
    public List<StoreList> selectList() {
        return storeListService.selectAll();
    }

    @PostMapping("/insert")
    public boolean insert(@RequestBody StoreList store) {
        return storeListService.insert(store);
    }

    @PostMapping("/condition")
    public StoreList selectByCondition(@RequestBody Store store) {
        return storeListService.selectByCondition(store);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return storeListService.delete(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody StoreList store) {
        return storeListService.update(store);
    }

    @GetMapping("/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        Integer selectCount = storeListService.selectCount();
        List<StoreList> storeLists = storeListService.selectByPage(page, size);
        results.put("total", selectCount);
        results.put("data", storeLists);
        return results;
    }
}
