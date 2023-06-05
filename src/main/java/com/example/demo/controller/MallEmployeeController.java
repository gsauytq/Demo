/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.controller;

import com.example.demo.dto.Employee;
import com.example.demo.pojo.MallEmployee;
import com.example.demo.service.MallEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mall-employee")
public class MallEmployeeController {

    private final MallEmployeeService mallEmployeeService;

    public MallEmployeeController(MallEmployeeService mallEmployeeService) {
        this.mallEmployeeService = mallEmployeeService;
    }

    @GetMapping
    public List<MallEmployee> selectAll() {
        List<MallEmployee> mallEmployees = mallEmployeeService.selectAllEmployees();
        return mallEmployees;
    }

    @PostMapping
    public boolean insert(@RequestBody MallEmployee mallEmployee) {
        boolean insert = mallEmployeeService.insert(mallEmployee);
        return insert;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        boolean delete = mallEmployeeService.delete(id);
        return delete;
    }

    @PutMapping
    public boolean update(@RequestBody MallEmployee mallEmployee) {
        boolean update = mallEmployeeService.update(mallEmployee);
        return update;
    }

    @PostMapping("/condition")
    public MallEmployee selectByCondition(@RequestBody Employee mallEmployee) {
        MallEmployee mallEmployeeResult = mallEmployeeService.selectByCondition(mallEmployee);
        return mallEmployeeResult;
    }

    @GetMapping("/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<MallEmployee> data = mallEmployeeService.selectByPage(page, size);
        Integer total = mallEmployeeService.selectCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }
}
