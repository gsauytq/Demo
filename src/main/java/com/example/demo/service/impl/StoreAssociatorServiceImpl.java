/**
 * @author 12432
 * @date 2023/05/24
 */
package com.example.demo.service.impl;

import com.example.demo.dao.StoreAssociatorListDAO;
import com.example.demo.dto.Associator;
import com.example.demo.pojo.StoreAssociator;
import com.example.demo.pojo.StoreList;
import com.example.demo.service.StoreAssociatorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreAssociatorServiceImpl implements StoreAssociatorService {

    private final StoreAssociatorListDAO storeAssociatorListDAO;

    public StoreAssociatorServiceImpl(StoreAssociatorListDAO storeAssociatorListDAO) {
        this.storeAssociatorListDAO = storeAssociatorListDAO;
    }

    @Override
    public boolean insert(StoreAssociator storeAssciator) {
        int insert = storeAssociatorListDAO.insert(storeAssciator);
        return insert == 1;
    }

    @Override
    public boolean delete(Integer id) {
        int delete = storeAssociatorListDAO.delete(id);
        return delete == 1;
    }

    @Override
    public boolean update(StoreAssociator storeAssciator) {
        int update = storeAssociatorListDAO.update(storeAssciator);
        return update == 1;
    }

    @Override
    public List<StoreAssociator> selectList() {
        List<StoreAssociator> storeAssociators = storeAssociatorListDAO.selectList();
        return storeAssociators;
    }

    @Override
    public StoreAssociator selectByCondition(Associator storeAssciator) {
        StoreAssociator storeAssociator = storeAssociatorListDAO.selectByCondition(storeAssciator);
        return storeAssociator;
    }

    @Override
    public List<StoreAssociator> selectByPage(int pageNo, int pageSize) {
        pageNo = (pageNo - 1) * pageSize;
        List<StoreAssociator> storeLists = storeAssociatorListDAO.selectByPage(pageNo, pageSize);
        return storeLists;
    }

    @Override
    public int selectCount() {
        int selectCount = storeAssociatorListDAO.selectCount();
        return selectCount;
    }
}
