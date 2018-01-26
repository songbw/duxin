package com.jiannei.duxin.dto;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 货单产品表
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */

public class OrderProductDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */

    private Long id;
    /**
     * 货单号
     */

    private String orderId;
    /**
     * 产品订单号
     */

    private String productOrder;
    /**
     * 产品名称
     */

    private String name;
    /**
     * 产品规格
     */

    private String specification;
    /**
     * 产品硬度
     */

    private String hardness;
    /**
     * 产品材质
     */

    private String texture;
    /**
     * 产品颜色
     */

    private String color;
    /**
     * 客户货单的产品重量
     */

    private Double customerWeight;
    /**
     * 实际产品称重
     */

    private Double weight;
    /**
     * 备注
     */

    private String remark;
    /**
     * 状态（0：进厂；1：已分拣；2：已加工；3：已打包；4：已入库；5：已出库）
     */

    private Integer status;

    private Integer priority;

    private Date createdAt;

    private Date updatedAt;
    /**
     * 客户ID
     */

    private Long customerId;
    /**
     * dealer_id
     */

    private Long dealerId;
    /**
     * 单价
     */

    private BigDecimal price;
    /**
     * 总价
     */

    private BigDecimal totalPrice;


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

    public String getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(String productOrder) {
        this.productOrder = productOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getHardness() {
        return hardness;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getCustomerWeight() {
        return customerWeight;
    }

    public void setCustomerWeight(Double customerWeight) {
        this.customerWeight = customerWeight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public void setDealerId(Long dealerId) {
        this.dealerId = dealerId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

}
