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
public class Commodity implements Serializable {
    private String commodityName;
    private String brand;
    private String productionEnterprises;
    private String yieldly;
    private static final long serialVersionUID = 9347L;
}
