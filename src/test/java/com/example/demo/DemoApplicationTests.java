package com.example.demo;

import com.example.demo.dao.StoreListDAO;
import com.example.demo.pojo.StoreList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private StoreListDAO storeListDAO;

    @Test
    void insertStoreList(){
        List<StoreList> storeLists = storeListDAO.selectList();
        for (StoreList store : storeLists) {
            System.out.println("store = " + store);
        }
    }
}
