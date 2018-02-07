package com.jiannei.duxin.dto;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */

public class RoleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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

    private Long adminId;
    /**
     * 创建时间
     */

    private Date createdAt;
    /**
     * 更新时间
     */

    private Date updatedAt;

    private List<RoleResourceDTO> roleResourceDTOS;


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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public List<RoleResourceDTO> getRoleResourceDTOS() {
        return roleResourceDTOS;
    }

    public void setRoleResourceDTOS(List<RoleResourceDTO> roleResourceDTOS) {
        this.roleResourceDTOS = roleResourceDTOS;
    }
}
