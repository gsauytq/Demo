/**
 * @author 12432
 * @date 2023/05/10
 */
package com.example.demo.service.impl;

import com.example.demo.dao.CommodityListDAO;
import com.example.demo.dto.Commodity;
import com.example.demo.pojo.CommodityList;
import com.example.demo.service.CommodityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityListServiceImpl implements CommodityListService {

    private final CommodityListDAO commodityListDAO;

    public CommodityListServiceImpl(CommodityListDAO commodityListDAO) {
        this.commodityListDAO = commodityListDAO;
    }

    @Override
    public boolean insert(CommodityList commodity) {
        int insert = commodityListDAO.insert(commodity);
        return insert == 1;
    }

    @Override
    public boolean delete(int id) {
        int delete = commodityListDAO.delete(id);
        return delete == 1;
    }

    @Override
    public boolean update(CommodityList commodity) {
        int update = commodityListDAO.update(commodity);
        return update == 1;
    }

    @Override
    public List<CommodityList> selectAll() {
        List<CommodityList> commodityLists = commodityListDAO.selectList();
        return commodityLists;
    }

    @Override
    public CommodityList selectByCondition(Commodity commodity) {
        CommodityList commodityList = commodityListDAO.selectByCondition(commodity);
        return commodityList;
    }

    @Override
    public List<CommodityList> selectByPage(int page, int size) {
        page = (page - 1) * size;
        List<CommodityList> commodityLists = commodityListDAO.selectByPage(page, size);
        return commodityLists;
    }

    @Override
    public int selectCount() {
        int selectCount = commodityListDAO.selectCount();
        return selectCount;
    }
}
