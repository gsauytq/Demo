/**
 * @author 12432
 * @date 2023/05/30
 */
package com.example.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class InOutNumber {
    private Integer incoming;
    private Integer outgoing;
}
