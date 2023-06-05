/**
 * @author 12432
 * @date 2023/04/23
 */
package com.example.demo.pojo;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class StorageAdministrators implements Serializable {
    private Integer administratorsId;
    private String administratorsName;
    private String gender;
    private Byte age;
    private String phone;
    private static final long serialVersionUID = 38493742L;
}
