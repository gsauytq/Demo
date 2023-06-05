/**
 * @author 12432
 * @date 2023/05/17
 */
package com.example.demo.service.impl;

import com.example.demo.dao.AdministratorsDAO;
import com.example.demo.dto.Administrator;
import com.example.demo.pojo.MallAdministrators;
import com.example.demo.pojo.StoreAdministrators;
import com.example.demo.service.AdministratorsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorsServiceImpl implements AdministratorsService {

    private final AdministratorsDAO administratorsDAO;

    public AdministratorsServiceImpl(AdministratorsDAO administratorsDAO) {
        this.administratorsDAO = administratorsDAO;
    }

    @Override
    public List<MallAdministrators> selectAll() {
        return administratorsDAO.selectAll();
    }

    @Override
    public List<MallAdministrators> selectMallAdministratorListByPage(int page, int size) {
        page = (page - 1) * size;
        List<MallAdministrators> mallAdministrators = administratorsDAO.selectMallAdministratorListByPage(page, size);
        return mallAdministrators;
    }

    @Override
    public int selectMallAdministratorsCount() {
        int selectMallAdministratorsCount = administratorsDAO.selectMallAdministratorsCount();
        return selectMallAdministratorsCount;
    }

    @Override
    public boolean insertMallAdministrators(MallAdministrators mallAdministrators) {
        int insertMallAdministrators = administratorsDAO.insertMallAdministrators(mallAdministrators);
        return insertMallAdministrators == 1;
    }

    @Override
    public boolean deleteMallAdministrators(int administratorsId) {
        int deleteMallAdministrators = administratorsDAO.deleteMallAdministrators(administratorsId);
        return deleteMallAdministrators == 1;
    }

    @Override
    public boolean updateMallAdministrators(MallAdministrators mallAdministrators) {
        int updateMallAdministrators = administratorsDAO.updateMallAdministrators(mallAdministrators);
        return updateMallAdministrators == 1;
    }

    @Override
    public MallAdministrators selectMallAdministratorsByCondition(Administrator administrator) {
        MallAdministrators mallAdministrators = administratorsDAO.selectMallAdministratorsByCondition(administrator);
        return mallAdministrators;
    }

    @Override
    public List<StoreAdministrators> selectStoreAll() {
        List<StoreAdministrators> storeAdministrators = administratorsDAO.selectStoreAll();
        return storeAdministrators;
    }

    @Override
    public List<StoreAdministrators> selectStoreAdministratorListByPage(int page, int size) {
        page = (page - 1) * size;
        List<StoreAdministrators> storeAdministrators = administratorsDAO.selectStoreAdministratorListByPage(page, size);
        return storeAdministrators;
    }

    @Override
    public int selectStoreAdministratorsCount() {
        int selectCount = administratorsDAO.selectStoreAdministratorsCount();
        return selectCount;
    }

    @Override
    public boolean insertStoreAdministrators(StoreAdministrators storeAdministrators) {
        int insert = administratorsDAO.insertStoreAdministrators(storeAdministrators);
        return insert == 1;
    }

    @Override
    public boolean deleteStoreAdministrators(Integer id) {
        int delete = administratorsDAO.deleteStoreAdministrators(id);
        return delete == 1;
    }

    @Override
    public boolean updateStoreAdministrators(StoreAdministrators storeAdministrators) {
        int update = administratorsDAO.updateStoreAdministrators(storeAdministrators);
        return update == 1;
    }

    @Override
    public StoreAdministrators selectStoreAdministratorsByCondition(Administrator administrator) {
        StoreAdministrators storeAdministrators = administratorsDAO.selectStoreAdministratorsByCondition(administrator);
        return storeAdministrators;
    }
}
