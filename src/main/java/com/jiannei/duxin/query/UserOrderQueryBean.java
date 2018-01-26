package com.jiannei.duxin.query;

import java.util.Date;
import java.math.BigDecimal;



/**
 * <p>
 * 货单表
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */

public class UserOrderQueryBean extends QueryBean {

    /**
     * ID
     */

    private Long id;
    /**
     * 货单号
     */

    private String orderId;
    /**
     * 用户ID
     */

    private Long customerId;
    /**
     * 用户名称
     */

    private String customerName;
    /**
     * 用户电话
     */

    private String customerPhone;
    /**
     * 车牌号
     */

    private String carNumber;
    /**
     * 总重量
     */

    private Double totalWeight;
    /**
     * 车重
     */

    private Double carWeight;
    /**
     * 状态（0：已进厂；1：已分拣：2：已镀锌；3：已入库；4：已出库）
     */

    private Integer status;
    /**
     * 备注
     */

    private String remark;

    private Date createdAt;

    private Date updatedAt;
    /**
     * dealer id
     */

    private Long dealerId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getCarWeight() {
        return carWeight;
    }

    public void setCarWeight(Double carWeight) {
        this.carWeight = carWeight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

}
