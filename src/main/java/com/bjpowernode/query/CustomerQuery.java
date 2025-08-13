package com.bjpowernode.query;

import lombok.Data;

@Data
public class CustomerQuery {
    private Integer clueId;
    private Integer product;
    private String description;
    private Data nextContactTime;
}
