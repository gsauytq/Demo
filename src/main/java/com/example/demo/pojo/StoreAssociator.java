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
public class StoreAssociator implements Serializable {
    private Integer associatorId;
    private String associatorName;
    private String gender;
    private Byte age;
    private String phone;
    private String email;
    private Date joinTime;
    private Integer total;
    private String organization;
    private static final long serialVersionUID = 58477423L;

    public java.sql.Date getJoinTime() {
        return DateUtil.utilToSql(this.joinTime);
    }
}
