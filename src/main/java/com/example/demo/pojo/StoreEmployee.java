/**
 * @author 12432
 * @date 2023/04/23
 */
package com.example.demo.pojo;

import com.example.demo.util.DateUtil;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class StoreEmployee implements Serializable {
    private Integer employeeId;
    private String employeeName;
    private Byte age;
    private String gender;
    private Date workTime;
    private BigDecimal salary;
    private String phone;
    private String email;
    private String organization;
    private static final long serialVersionUID = 39483984L;

    public java.sql.Date getWorkTime() {
        return DateUtil.utilToSql(this.workTime);
    }
}
