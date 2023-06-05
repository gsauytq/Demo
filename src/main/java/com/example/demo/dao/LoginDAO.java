package com.example.demo.dao;

import com.example.demo.dto.Login;
import com.example.demo.pojo.LoginList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginDAO {

    @Select("select id, admin, password, authority, info from login " +
            "where admin = #{admin} and password = #{password} and authority = #{authority};")
    LoginList login(Login login);

    @Select("select id, admin, password, authority from login where id = #{id};")
    Login selectById(int id);
}
