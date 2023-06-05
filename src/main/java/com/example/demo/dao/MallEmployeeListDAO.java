package com.example.demo.dao;

import com.example.demo.dto.Employee;
import com.example.demo.pojo.MallEmployee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MallEmployeeListDAO {

    @Insert("insert into mall_employee(employee_name, age, gender, salary, phone, email) " +
            "values (#{employeeName}, #{age}, #{gender}, #{salary}, #{phone}, #{email});")
    int insert(MallEmployee mallEmployee);

    @Delete("delete from mall_employee where employee_id = #{id}")
    int delete(int id);

    @Update("update mall_employee " +
            "set employee_name = #{employeeName}, age = #{age}, gender = #{gender}, salary = #{salary}, phone = #{phone}, email = #{email} where employee_id = #{employeeId};")
    int update(MallEmployee mallEmployee);

    @Select("<script>"
            + "select employee_id, employee_name, age, gender, salary, phone, email "
            + "from mall_employee"
            + "<where> "
            + "employee_name = #{employeeName} "
            + "<if test='phone != null and phone != \"\"'> "
            + "and phone = #{phone} "
            + "</if> "
            + "<if test='email != null and email != \"\"'> "
            + "and email = #{email} "
            + "</if> "
            + "</where> "
            + "</script>")
    @Results({
            @Result(column = "employee_id", property = "employeeId"),
            @Result(column = "employee_name", property = "employeeName")
    })
    MallEmployee selectByCondition(Employee employee);

    @Select("select employee_id, employee_name, age, gender, salary, phone, email from mall_employee;")
    @Results({
            @Result(column = "employee_id", property = "employeeId"),
            @Result(column = "employee_name", property = "employeeName")
    })
    List<MallEmployee> selectList();

    @Select("select employee_id, employee_name, age, gender, salary, phone, email from mall_employee " +
            "limit #{page}, #{size};")
    @Results({
            @Result(column = "employee_id", property = "employeeId"),
            @Result(column = "employee_name", property = "employeeName")
    })
    List<MallEmployee> selectByPage(int page, int size);

    @Select("select count(1) from mall_employee;")
    int selectCount();
}
