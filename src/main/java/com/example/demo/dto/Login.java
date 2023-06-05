/**
 * @author 12432
 * @date 2023/05/19
 */
package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Login {
    private Integer id;
    private String admin;
    private String password;
    private Byte authority;
    private String token;
    private String authorityInfo;

    public Login(Integer id, String admin, String password, Byte authority) {
        this.id = id;
        this.admin = admin;
        this.password = password;
        this.authority = authority;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public Byte getAuthority() {
        return authority;
    }

    @JsonProperty
    public void setAuthority(Byte authority) {
        this.authority = authority;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }
}
