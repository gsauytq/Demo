/**
 * @author 12432
 * @date 2023/05/12
 */
package com.example.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Setter
@Getter
public class Employee {
    private String employeeName;
    private String phone;
    private String email;
}
