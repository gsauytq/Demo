package com.example.demo.service;

import com.example.demo.dto.InOutNumber;
import org.apache.ibatis.annotations.Select;

public interface StorageTrafficService {
    InOutNumber[] inoutNumberData(int id);
    int[] typeSaleData(int id);
    String[] typeData(int id);
}
