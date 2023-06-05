/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.service.impl;

import com.example.demo.dao.StorageListDAO;
import com.example.demo.dto.Storage;
import com.example.demo.pojo.StorageList;
import com.example.demo.service.StorageListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageListServiceImpl implements StorageListService {
    private final StorageListDAO storageListDAO;

    public StorageListServiceImpl(StorageListDAO storageListDAO) {
        this.storageListDAO = storageListDAO;
    }

    @Override
    public boolean insert(StorageList storage) {
        int insert = storageListDAO.insert(storage);
        return insert == 1;
    }

    @Override
    public boolean delete(int id) {
        int delete = storageListDAO.delete(id);
        return delete == 1;
    }

    @Override
    public boolean update(StorageList storage) {
        int update = storageListDAO.update(storage);
        return update == 1;
    }

    @Override
    public StorageList selectByCondition(Storage storage) {
        StorageList storageList = storageListDAO.selectByCondition(storage);
        return storageList;
    }

    @Override
    public List<StorageList> selectAll() {
        List<StorageList> storageLists = storageListDAO.selectList();
        return storageLists;
    }

    @Override
    public List<StorageList> selectByPage(int page, int size) {
        page = (page - 1) * size;
        List<StorageList> storageLists = storageListDAO.selectByPage(page, size);
        return storageLists;
    }

    @Override
    public int selectCount() {
        int selectCount = storageListDAO.selectCount();
        return selectCount;
    }
}
