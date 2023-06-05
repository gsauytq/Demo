/**
 * @author 12432
 * @date 2023/04/23
 */
package com.example.demo.pojo;

import com.example.demo.util.DateUtil;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Data
public class StoreList implements Serializable {
    private Integer storeId;
    private String storeName;
    private String shopkeeper;
    private Date createTime;
    private String status;
    private String description;
    private String phone;
    private static final long serialVersionUID = 29392831L;

    public java.sql.Date getCreateTime() {
        return DateUtil.utilToSql(this.createTime);
    }
}
