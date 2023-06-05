package com.example.demo.service;

import com.example.demo.dto.Employee;
import com.example.demo.pojo.MallEmployee;

import java.util.List;

public interface MallEmployeeService {

    List<MallEmployee> selectAllEmployees();
    boolean insert(MallEmployee mallEmployee);
    boolean delete(int id);
    boolean update(MallEmployee mallEmployee);
    MallEmployee selectByCondition(Employee employee);
    List<MallEmployee> selectByPage(int page, int size);
    int selectCount();
}
