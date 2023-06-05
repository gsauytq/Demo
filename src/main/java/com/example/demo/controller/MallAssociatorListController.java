/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.controller;

import com.example.demo.dto.Associator;
import com.example.demo.pojo.MallAssociator;
import com.example.demo.service.MallAssociatorListService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mall-associator")
public class MallAssociatorListController {

    private final MallAssociatorListService mallAssociatorService;

    public MallAssociatorListController(MallAssociatorListService mallAssociatorService) {
        this.mallAssociatorService = mallAssociatorService;
    }

    @GetMapping
    public List<MallAssociator> selectList() {
        return mallAssociatorService.selectAllAssociators();
    }

    @PostMapping
    public boolean insert(@RequestBody MallAssociator mallAssociator) {
        return mallAssociatorService.insert(mallAssociator);
    }

    @PostMapping("/condition")
    public MallAssociator selectByCondition(@RequestBody Associator mallAssociator) {
        return mallAssociatorService.selectByCondition(mallAssociator);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        return mallAssociatorService.delete(id);
    }

    @PutMapping
    public boolean update(@RequestBody MallAssociator mallAssociator) {
        return mallAssociatorService.update(mallAssociator);
    }

    @GetMapping("/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<MallAssociator> data = mallAssociatorService.selectByPage(page, size);
        Integer total = mallAssociatorService.selectCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }
}
