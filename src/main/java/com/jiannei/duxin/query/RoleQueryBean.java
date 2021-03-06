package com.jiannei.duxin.query;

import java.util.Date;
import java.math.BigDecimal;


/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */

public class RoleQueryBean extends QueryBean {

    /**
     * ID
     */

    private Long id;
    /**
     * 名称
     */

    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
