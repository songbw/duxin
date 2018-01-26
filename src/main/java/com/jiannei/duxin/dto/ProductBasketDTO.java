package com.jiannei.duxin.dto;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 产品分拣表
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */

public class ProductBasketDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    /**
     * 货单号
     */

    private String orderId;
    /**
     * 产品单号
     */

    private String productOrder;
    /**
     * 筐号
     */

    private Integer basketNum;
    /**
     * 分拣人
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

    public Integer getBasketNum() {
        return basketNum;
    }

    public void setBasketNum(Integer basketNum) {
        this.basketNum = basketNum;
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

}
