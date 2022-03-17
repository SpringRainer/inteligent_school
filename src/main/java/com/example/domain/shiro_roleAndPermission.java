package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class shiro_roleAndPermission implements Serializable {
    private String password;
    private String role;
    private String permission;
}
