package com.example.demo.service;

import com.example.demo.dto.Commodity;
import com.example.demo.pojo.CommodityList;

import java.util.List;

public interface CommodityListService {
    boolean insert(CommodityList commodity);
    boolean delete(int id);
    boolean update(CommodityList commodity);
    List<CommodityList> selectAll();
    CommodityList selectByCondition(Commodity commodity);
    List<CommodityList> selectByPage(int page, int size);
    int selectCount();
}
