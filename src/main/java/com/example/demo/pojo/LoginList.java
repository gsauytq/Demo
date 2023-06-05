/**
 * @author 12432
 * @date 2023/05/19
 */
package com.example.demo.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@ToString
public class LoginList {
    private Integer id;
    private String admin;
    private String password;
    private Byte authority;
    private Integer info;
}
