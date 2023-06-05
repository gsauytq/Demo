/**
 * @author 12432
 * @date 2023/05/24
 */
package com.example.demo.controller;

import com.example.demo.dto.Associator;
import com.example.demo.pojo.StoreAssociator;
import com.example.demo.service.StoreAssociatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/store-associator")
public class StoreAssociatorController {

    private final StoreAssociatorService storeAssociatorService;

    public StoreAssociatorController(StoreAssociatorService storeAssociatorService) {
        this.storeAssociatorService = storeAssociatorService;
    }

    @PostMapping
    public boolean insert(@RequestBody StoreAssociator storeAssociator) {
        boolean insert = storeAssociatorService.insert(storeAssociator);
        return insert;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean delete = storeAssociatorService.delete(id);
        return delete;
    }

    @PutMapping
    public boolean update(@RequestBody StoreAssociator storeAssociator) {
        boolean update = storeAssociatorService.update(storeAssociator);
        return update;
    }

    @GetMapping
    public List<StoreAssociator> selectList() {
        List<StoreAssociator> storeAssociators = storeAssociatorService.selectList();
        return storeAssociators;
    }

    @PostMapping("/condition")
    public StoreAssociator selectByCondition(@RequestBody Associator associator) {
        StoreAssociator storeAssociator = storeAssociatorService.selectByCondition(associator);
        return storeAssociator;
    }

    @GetMapping("/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<StoreAssociator> data = storeAssociatorService.selectByPage(page, size);
        Integer total = storeAssociatorService.selectCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }
}
