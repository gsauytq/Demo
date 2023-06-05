/**
 * @author 12432
 * @date 2023/05/30
 */
package com.example.demo.service.impl;

import com.example.demo.dao.StorageTrafficDAO;
import com.example.demo.dto.InOutNumber;
import com.example.demo.service.StorageTrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageTrafficServiceImpl implements StorageTrafficService {

    private final StorageTrafficDAO storageTrafficDAO;

    public StorageTrafficServiceImpl(StorageTrafficDAO storageTrafficDAO) {
        this.storageTrafficDAO = storageTrafficDAO;
    }

    @Override
    public InOutNumber[] inoutNumberData(int id) {
        InOutNumber[] inoutNumberData = storageTrafficDAO.inoutNumberData(id);
        return inoutNumberData;
    }

    @Override
    public int[] typeSaleData(int id) {
        int[] typeSaleData = storageTrafficDAO.typeSaleData(id);
        return typeSaleData;
    }

    @Override
    public String[] typeData(int id) {
        String[] typeData = storageTrafficDAO.typeData(id);
        return typeData;
    }
}
