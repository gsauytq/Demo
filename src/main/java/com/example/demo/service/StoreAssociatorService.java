package com.example.demo.service;

import com.example.demo.dto.Associator;
import com.example.demo.pojo.StoreAssociator;
import com.example.demo.pojo.StoreList;

import java.util.List;

public interface StoreAssociatorService {
    boolean insert(StoreAssociator storeAssciator);
    boolean delete(Integer id);
    boolean update(StoreAssociator storeAssciator);
    List<StoreAssociator> selectList();
    StoreAssociator selectByCondition(Associator storeAssciator);
    List<StoreAssociator> selectByPage(int pageNo, int pageSize);
    int selectCount();
}
