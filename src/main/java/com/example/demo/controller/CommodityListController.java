/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.controller;

import com.example.demo.dto.Commodity;
import com.example.demo.pojo.CommodityList;
import com.example.demo.service.impl.CommodityListServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/commodity-list")
public class CommodityListController {

    private final CommodityListServiceImpl commodityListServiceImpl;

    public CommodityListController(CommodityListServiceImpl commodityListServiceImpl) {
        this.commodityListServiceImpl = commodityListServiceImpl;
    }

    @PostMapping
    public boolean insert(@RequestBody CommodityList commodityList) {
        boolean insert = commodityListServiceImpl.insert(commodityList);
        return insert;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable int id) {
        boolean delete = commodityListServiceImpl.delete(id);
        return delete;
    }

    @PutMapping
    public boolean update(@RequestBody CommodityList commodity) {
        boolean update = commodityListServiceImpl.update(commodity);
        return update;
    }

    @PostMapping("/condition")
    public CommodityList selectByCondition(@RequestBody Commodity commodity) {
        CommodityList commodityList = commodityListServiceImpl.selectByCondition(commodity);
        return commodityList;
    }

    @GetMapping
    public List<CommodityList> selectAll() {
        List<CommodityList> commodityLists = commodityListServiceImpl.selectAll();
        return commodityLists;
    }

    @GetMapping("/page")
    public HashMap<String, Object> selectByPage(@RequestParam Integer page, @RequestParam Integer size) {
        HashMap<String, Object> results = new HashMap<>();
        List<CommodityList> data = commodityListServiceImpl.selectByPage(page, size);
        Integer total = commodityListServiceImpl.selectCount();
        results.put("total", total);
        results.put("data", data);
        return results;
    }
}
