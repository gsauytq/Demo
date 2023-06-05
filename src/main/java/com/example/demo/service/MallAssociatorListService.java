package com.example.demo.service;

import com.example.demo.dto.Associator;
import com.example.demo.pojo.MallAssociator;

import java.util.List;

public interface MallAssociatorListService {
    boolean insert(MallAssociator mallAssociator);
    boolean delete(int id);
    boolean update(MallAssociator mallAssociator);
    MallAssociator selectByCondition(Associator mallAssociator);
    List<MallAssociator> selectAllAssociators();
    List<MallAssociator> selectByPage(int page, int size);
    int selectCount();
}
