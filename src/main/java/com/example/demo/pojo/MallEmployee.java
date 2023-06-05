/**
 * @author 12432
 * @date 2023/04/23
 */
package com.example.demo.pojo;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class MallEmployee {
    private Integer employeeId;
    private String employeeName;
    private Byte age;
    private String gender;
    private BigDecimal salary;
    private String phone;
    private String email;
}
