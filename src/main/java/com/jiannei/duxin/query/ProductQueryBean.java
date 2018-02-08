package com.jiannei.duxin.query;

import java.util.Date;
import java.math.BigDecimal;


/**
 * <p>
 * 产品信息表
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */

public class ProductQueryBean extends QueryBean {

    /**
     * ID
     */

    private Long id;
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
     * 产品表色
     */

    private String color;
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
    /**
     * 创建者ID（dealer）
     */

    private Long creator;
    /**
     * 单价
     */

    private BigDecimal price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
