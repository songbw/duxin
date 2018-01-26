package com.jiannei.duxin.dto;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 产品打包列表
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */

public class ProductPackageDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    /**
     * 货单号
     */

    private String orderId;
    /**
     * 产品货单号
     */

    private String productOrder;
    /**
     * 包号
     */

    private String packageNum;
    /**
     * 包重
     */

    private Double packageWeight;
    /**
     * 打包人
     */

    private String sortUser;
    /**
     * 存放区域
     */

    private String area;
    /**
     * 创建时间
     */

    private Date createdAt;
    /**
     * 更新时间
     */

    private Date updatedAt;
    /**
     * 状态（0：默认；1：入库；2：出库）
     */

    private Integer status;


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

    public String getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(String packageNum) {
        this.packageNum = packageNum;
    }

    public Double getPackageWeight() {
        return packageWeight;
    }

    public void setPackageWeight(Double packageWeight) {
        this.packageWeight = packageWeight;
    }

    public String getSortUser() {
        return sortUser;
    }

    public void setSortUser(String sortUser) {
        this.sortUser = sortUser;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
