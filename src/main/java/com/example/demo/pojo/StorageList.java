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
public class StorageList implements Serializable {
    private Integer storageId;
    private Date createTime;
    private Integer storageVolume;
    private Integer capacityRemaining;
    private String status;
    private String summary;
    private String storageAdministrators;
    private static final long serialVersionUID = 48793742L;

    public String getCreateTime() {
        return DateUtil.utilToStr(this.createTime);
    }
}
