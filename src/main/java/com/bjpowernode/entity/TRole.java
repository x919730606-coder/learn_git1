package com.bjpowernode.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色表
 * t_role
 */
@Data
public class TRole implements Serializable {
    private Integer id;

    private String role;

    private String roleName;

    private static final long serialVersionUID = 1L;
}