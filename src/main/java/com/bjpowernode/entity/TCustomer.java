package com.bjpowernode.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 客户表
 * t_customer
 */
@Data
public class TCustomer implements Serializable {

    private TUser ownerDo;
    private TActivity activityDo;
    private TClue clueDo;
    private TDicValue appellationDo;
    private TDicValue intentionStateDo;
    private TDicValue needLoanDo;
    private TDicValue stateDo;
    private TDicValue sourceDo;
    private TProduct intentionProductDo;
    /**
     * 主键，自动增长，客户ID
     */
    private Integer id;

    /**
     * 线索ID
     */
    private Integer clueId;

    /**
     * 选购产品
     */
    private Integer product;

    /**
     * 客户描述
     */
    private String description;

    /**
     * 下次联系时间
     */
    private Date nextContactTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 编辑时间
     */
    private Date editTime;

    /**
     * 编辑人
     */
    private Integer editBy;

    private static final long serialVersionUID = 1L;
}