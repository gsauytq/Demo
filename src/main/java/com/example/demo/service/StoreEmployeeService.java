package com.example.demo.service;

import com.example.demo.dto.Employee;
import com.example.demo.pojo.StoreEmployee;

import java.util.List;

public interface StoreEmployeeService {
    boolean insert(StoreEmployee storeEmployee);
    boolean delete(Integer id);
    boolean update(StoreEmployee storeEmployee);
    List<StoreEmployee> selectList();
    StoreEmployee selectByCondition(Employee employee);
    List<StoreEmployee> selectByPage(Integer page, Integer size);
    int selectCount();
}
