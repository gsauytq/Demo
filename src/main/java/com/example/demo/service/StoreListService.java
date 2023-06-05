/**
 * @author 12432
 * @date 2023/05/09
 */
package com.example.demo.service;

import com.example.demo.dto.Store;
import com.example.demo.pojo.StoreList;

import java.util.List;

public interface StoreListService {

    boolean insert(StoreList store);
    boolean delete(int id);
    boolean update(StoreList store);
    StoreList selectByCondition(Store store);
    List<StoreList> selectAll();
    List<StoreList> selectByPage(int page, int size);
    int selectCount();
}
