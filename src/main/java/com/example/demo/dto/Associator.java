/**
 * @author 12432
 * @date 2023/04/23
 */
package com.example.demo.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Associator implements Serializable {
    private String associatorName;
    private String email;
    private String phone;
    private static final long serialVersionUID = 9348L;
}
