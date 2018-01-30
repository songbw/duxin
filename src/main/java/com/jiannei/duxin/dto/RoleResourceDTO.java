package com.jiannei.duxin.dto;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 角色资源表
 * </p>
 * @author Songbw
 * @since 2018-01-30
 */

public class RoleResourceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */

    private Long id;
    /**
     * 角色ID
     */

    private Long roleId;
    /**
     * 资源ID
     */

    private Long resId;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
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
