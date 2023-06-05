/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.service.impl;

import com.example.demo.dao.MallAssociatorListDAO;
import com.example.demo.dto.Associator;
import com.example.demo.pojo.MallAssociator;
import com.example.demo.service.MallAssociatorListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MallAssociatorListServiceImpl implements MallAssociatorListService {

    private final MallAssociatorListDAO associatorListDAO;

    public MallAssociatorListServiceImpl(MallAssociatorListDAO associatorListDAO) {
        this.associatorListDAO = associatorListDAO;
    }

    @Override
    public boolean insert(MallAssociator mallAssociator) {
        int insert = associatorListDAO.insert(mallAssociator);
        return insert == 1;
    }

    @Override
    public boolean delete(int id) {
        int delete = associatorListDAO.delete(id);
        return delete == 1;
    }

    @Override
    public boolean update(MallAssociator mallAssociator) {
        int update = associatorListDAO.update(mallAssociator);
        return update == 1;
    }

    @Override
    public MallAssociator selectByCondition(Associator mallAssociator) {
        return associatorListDAO.selectByConditon(mallAssociator);
    }

    @Override
    public List<MallAssociator> selectAllAssociators() {
        return associatorListDAO.selectList();
    }

    @Override
    public List<MallAssociator> selectByPage(int page, int size) {
        page = (page - 1) * size;
        List<MallAssociator> mallAssociators = associatorListDAO.selectByPage(page, size);
        return mallAssociators;
    }

    @Override
    public int selectCount() {
        int selectCount = associatorListDAO.selectCount();
        return selectCount;
    }
}
