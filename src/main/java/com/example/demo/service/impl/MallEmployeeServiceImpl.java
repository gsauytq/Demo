/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.service.impl;

import com.example.demo.dao.MallEmployeeListDAO;
import com.example.demo.dto.Employee;
import com.example.demo.pojo.MallEmployee;
import com.example.demo.service.MallEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallEmployeeServiceImpl implements MallEmployeeService {

    private final MallEmployeeListDAO mallEmployeeListDAO;

    public MallEmployeeServiceImpl(MallEmployeeListDAO mallEmployeeListDAO) {
        this.mallEmployeeListDAO = mallEmployeeListDAO;
    }

    @Override
    public List<MallEmployee> selectAllEmployees() {
        return mallEmployeeListDAO.selectList();
    }

    @Override
    public boolean insert(MallEmployee mallEmployee) {
        int insert = mallEmployeeListDAO.insert(mallEmployee);
        return insert == 1;
    }

    @Override
    public boolean delete(int id) {
        int delete = mallEmployeeListDAO.delete(id);
        return delete == 1;
    }

    @Override
    public boolean update(MallEmployee mallEmployee) {
        int update = mallEmployeeListDAO.update(mallEmployee);
        return update == 1;
    }

    @Override
    public MallEmployee selectByCondition(Employee employee) {
        MallEmployee mallEmployee = mallEmployeeListDAO.selectByCondition(employee);
        return mallEmployee;
    }

    @Override
    public List<MallEmployee> selectByPage(int page, int size) {
        page = (page - 1) * size;
        List<MallEmployee> mallEmployees = mallEmployeeListDAO.selectByPage(page, size);
        return mallEmployees;
    }

    @Override
    public int selectCount() {
        int selectCount = mallEmployeeListDAO.selectCount();
        return selectCount;
    }
}
