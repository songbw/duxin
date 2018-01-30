package com.jiannei.duxin.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 车辆信息表
 * </p>
 * @author Songbw
 * @since 2018-01-30
 */
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 车牌号
     */
    private String carNumber;
    /**
     * 描述
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 更新时间
     */
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Car{" +
        ", id=" + id +
        ", userId=" + userId +
        ", userType=" + userType +
        ", carNumber=" + carNumber +
        ", remark=" + remark +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
