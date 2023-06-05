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
@Getter
@Setter
@ToString
@Data
public class StoreAdministrators implements Serializable {
    private Integer administratorsId;
    private String administratorsName;
    private String gender;
    private Byte age;
    private String organization;
    private Date createTime;
    private String email;
    private String phone;
    private static final long serialVersionUID = 39459348L;

    public java.sql.Date getCreateTime() {
        return DateUtil.utilToSql(this.createTime);
    }
}
