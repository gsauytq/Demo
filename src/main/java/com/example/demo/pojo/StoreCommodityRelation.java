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
public class StoreCommodityRelation implements Serializable {
    private Integer id;
    private Integer fkStoreId;
    private Integer fkCommodityId;
    private static final long serialVersionUID = 45793423L;
}
