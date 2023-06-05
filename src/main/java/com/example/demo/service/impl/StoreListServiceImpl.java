/**
 * @author 12432
 * @date 2023/05/09
 */
package com.example.demo.service.impl;

import com.example.demo.dao.StoreListDAO;
import com.example.demo.dto.Store;
import com.example.demo.pojo.StoreList;
import com.example.demo.service.StoreListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreListServiceImpl implements StoreListService {

    private final StoreListDAO storeListDao;

    public StoreListServiceImpl(StoreListDAO storeListDao) {
        this.storeListDao = storeListDao;
    }

    @Override
    public boolean insert(StoreList store) {
        int insert = storeListDao.insert(store);
        return insert == 1;
    }

    @Override
    public boolean delete(int id) {
        int delete = storeListDao.delete(id);
        return delete == 1;
    }

    @Override
    public boolean update(StoreList store) {
        int update = storeListDao.update(store);
        return update == 1;
    }

    @Override
    public StoreList selectByCondition(Store store) {
        StoreList storeList = storeListDao.selectByCondition(store);
        return storeList;
    }

    @Override
    public List<StoreList> selectAll() {
        List<StoreList> storeLists = storeListDao.selectList();
        return storeLists;
    }

    @Override
    public List<StoreList> selectByPage(int page, int size) {
        page = (page - 1) * size;
        List<StoreList> storeLists = storeListDao.selectByPage(page, size);
        return storeLists;
    }

    @Override
    public int selectCount() {
        int selectCount = storeListDao.selectCount();
        return selectCount;
    }
}
