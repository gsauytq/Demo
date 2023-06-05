package com.example.demo.dao;

import com.example.demo.dto.Employee;
import com.example.demo.pojo.MallEmployee;
import com.example.demo.pojo.StoreEmployee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StoreEmployeeListDAO {

    @Insert("insert into store_employee(employee_name, age, gender, work_time, salary, phone, email, organization) " +
            "values (#{employeeName}, #{age}, #{gender}, date(sysdate()), #{salary}, #{phone}, #{email}, #{organization});")
    int insert(StoreEmployee storeEmployee);

    @Delete("delete from store_employee where employee_id = #{id}")
    int delete(int id);

    @Update("update store_employee " +
            "set employee_name = #{employeeName}, age = #{age}, gender = #{gender}, salary = #{salary}, phone = #{phone}, email = #{email} " +
            "where employee_id = #{employeeId};")
    int update(StoreEmployee storeEmployee);

    @Select("<script>"
            + "select employee_id, employee_name, age, gender, work_time, salary, phone, email, store_name "
            + "from store_employee_view"
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
            @Result(column = "employee_name", property = "employeeName"),
            @Result(column = "work_time", property = "workTime"),
            @Result(column = "store_name", property = "organization")
    })
    StoreEmployee selectByCondition(Employee employee);

    @Select("select employee_id, employee_name, age, gender, work_time, salary, phone, email, store_name from store_employee_view;")
    @Results({
            @Result(column = "employee_id", property = "employeeId"),
            @Result(column = "employee_name", property = "employeeName"),
            @Result(column = "work_time", property = "workTime"),
            @Result(column = "store_name", property = "organization")
    })
    List<StoreEmployee> selectList();

    @Select("select employee_id, employee_name, age, gender, work_time, salary, phone, email, store_name from store_employee_view " +
            "limit #{page}, #{size};")
    @Results({
            @Result(column = "employee_id", property = "employeeId"),
            @Result(column = "employee_name", property = "employeeName"),
            @Result(column = "work_time", property = "workTime"),
            @Result(column = "store_name", property = "organization")
    })
    List<StoreEmployee> selectByPage(int page, int size);

    @Select("select count(1) from store_employee_view;")
    int selectCount();
}
