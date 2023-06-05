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
@Setter
@Getter
@ToString
@Data
public class MallAdministrators implements Serializable {
    private Integer administratorsId;
    private String administratorsName;
    private String gender;
    private Byte age;
    private Date createTime;
    private String email;
    private String phone;
    private static final long serialVersionUID = 23847293L;

    public java.sql.Date getCreateTime() {
        return DateUtil.utilToSql(this.createTime);
    }
}
