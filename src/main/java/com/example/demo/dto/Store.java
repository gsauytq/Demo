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
public class Store implements Serializable {
    private String storeName;
    private String shopkeeper;
    private Byte status;
    private String phone;
    private static final long serialVersionUID = 8323L;
}
