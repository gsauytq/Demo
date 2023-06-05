/**
 * @author 12432
 * @date 2023/04/23
 */
package com.example.demo.pojo;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class CommodityList implements Serializable {
    private Integer commodityId;
    private String commodityName;
    private String yieldly;
    private String brand;
    private String productionEnterprises;
    private BigDecimal costPrice;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private static final long serialVersionUID = 34783421L;
}
