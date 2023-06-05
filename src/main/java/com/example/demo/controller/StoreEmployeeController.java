/**
 * @author 12432
 * @date 2023/05/24
 */
package com.example.demo.controller;

import com.example.demo.dto.Employee;
import com.example.demo.pojo.StoreEmployee;
import com.example.demo.service.StoreEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/store-employee")
public class StoreEmployeeController {

    private final StoreEmployeeService storeEmployeeService;

    public StoreEmployeeController(StoreEmployeeService storeEmployeeService) {
        this.storeEmployeeService = storeEmployeeService;
    }

    @PostMapping
    public boolean insert(@RequestBody StoreEmployee storeEmployee) {
        boolean insert = storeEmployeeService.insert(storeEmployee);
        return insert;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        boolean delete = storeEmployeeService.delete(id);
        return delete;
    }

    @PutMapping
    public boolean update(@RequestBody StoreEmployee store) {
        boolean update = storeEmployeeService.update(store);
        return update;
    }

    @GetMapping
    public List<StoreEmployee> selectList() {
        List<StoreEmployee> storeEmployees = storeEmployeeService.selectList();
        return storeEmployees;
    }

    @PostMapping("/condition")
    public StoreEmployee selectByCondition(@RequestBody Employee employee) {
        StoreEmployee storeEmployee = storeEmployeeService.selectByCondition(employee);
        return storeEmployee;
    }

    @GetMapping("/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<StoreEmployee> data = storeEmployeeService.selectByPage(page, size);
        Integer total = storeEmployeeService.selectCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }
}
