package com.example.demo.service;

import com.example.demo.dto.Storage;
import com.example.demo.pojo.StorageList;

import java.util.List;

public interface StorageListService {
    boolean insert(StorageList storage);
    boolean delete(int id);
    boolean update(StorageList storage);
    StorageList selectByCondition(Storage storage);
    List<StorageList> selectAll();
    List<StorageList> selectByPage(int page, int size);
    int selectCount();
}
