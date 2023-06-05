/**
 * @author 12432
 * @date 2023/05/22
 */
package com.example.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Data
public class Administrator {
    private String administratorsName;
    private String email;
    private String phone;
}
