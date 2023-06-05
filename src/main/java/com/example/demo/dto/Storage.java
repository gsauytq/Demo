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
public class Storage implements Serializable {
    private Integer storageId;
    private Byte status;
    private Integer storageAdministrators;
    private static final long serialVersionUID = 9347L;
}
