/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.controller;

import com.example.demo.dto.Storage;
import com.example.demo.pojo.StorageList;
import com.example.demo.service.StorageListService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/storage-list")
public class StorageListController {

    private final StorageListService storageListService;

    public StorageListController(StorageListService storageListService) {
        this.storageListService = storageListService;
    }

    @PostMapping
    public boolean insert(@RequestBody StorageList storage) {
        boolean insert = storageListService.insert(storage);
        return insert;
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable int id) {
        boolean delete = storageListService.delete(id);
        return delete;
    }

    @PutMapping
    public boolean update(@RequestBody StorageList storage) {
        boolean update = storageListService.update(storage);
        return update;
    }

    @PostMapping("/condition")
    public StorageList selectByCondition(@RequestBody Storage storage) {
        StorageList storageList = storageListService.selectByCondition(storage);
        return storageList;
    }

    @GetMapping
    public List<StorageList> selectAll() {
        List<StorageList> storageLists = storageListService.selectAll();
        return storageLists;
    }

    @GetMapping("/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<StorageList> data = storageListService.selectByPage(page, size);
        int total = storageListService.selectCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }
}
