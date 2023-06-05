/**
 * @author 12432
 * @date 2023/05/24
 */
package com.example.demo.service.impl;

import com.example.demo.dao.StoreEmployeeListDAO;
import com.example.demo.dto.Employee;
import com.example.demo.pojo.StoreEmployee;
import com.example.demo.service.StoreEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreEmployeeServiceImpl implements StoreEmployeeService {

    private final StoreEmployeeListDAO storeEmployeeListDAO;

    public StoreEmployeeServiceImpl(StoreEmployeeListDAO storeEmployeeListDAO) {
        this.storeEmployeeListDAO = storeEmployeeListDAO;
    }

    @Override
    public boolean insert(StoreEmployee storeEmployee) {
        int insert = storeEmployeeListDAO.insert(storeEmployee);
        return insert == 1;
    }

    @Override
    public boolean delete(Integer id) {
        int delete = storeEmployeeListDAO.delete(id);
        return delete == 1;
    }

    @Override
    public boolean update(StoreEmployee storeEmployee) {
        int update = storeEmployeeListDAO.update(storeEmployee);
        return update == 1;
    }

    @Override
    public List<StoreEmployee> selectList() {
        List<StoreEmployee> storeEmployees = storeEmployeeListDAO.selectList();
        return storeEmployees;
    }

    @Override
    public StoreEmployee selectByCondition(Employee employee) {
        StoreEmployee storeEmployee = storeEmployeeListDAO.selectByCondition(employee);
        return storeEmployee;
    }

    @Override
    public List<StoreEmployee> selectByPage(Integer page, Integer size) {
        page = (page - 1) * size;
        List<StoreEmployee> storeEmployees = storeEmployeeListDAO.selectByPage(page, size);
        return storeEmployees;
    }

    @Override
    public int selectCount() {
        int selectCount = storeEmployeeListDAO.selectCount();
        return selectCount;
    }
}
