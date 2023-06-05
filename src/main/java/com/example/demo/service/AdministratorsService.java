package com.example.demo.service;

import com.example.demo.dto.Administrator;
import com.example.demo.pojo.MallAdministrators;
import com.example.demo.pojo.StoreAdministrators;

import java.util.List;

public interface AdministratorsService {

    List<MallAdministrators> selectAll();
    List<MallAdministrators> selectMallAdministratorListByPage(int page, int size);
    int selectMallAdministratorsCount();
    boolean insertMallAdministrators(MallAdministrators mallAdministrators);
    boolean deleteMallAdministrators(int administratorsId);
    boolean updateMallAdministrators(MallAdministrators mallAdministrators);
    MallAdministrators selectMallAdministratorsByCondition(Administrator administrator);
    List<StoreAdministrators> selectStoreAll();
    List<StoreAdministrators> selectStoreAdministratorListByPage(int page, int size);
    int selectStoreAdministratorsCount();
    boolean insertStoreAdministrators(StoreAdministrators storeAdministrators);
    boolean deleteStoreAdministrators(Integer id);
    boolean updateStoreAdministrators(StoreAdministrators storeAdministrators);
    StoreAdministrators selectStoreAdministratorsByCondition(Administrator administrator);
}
