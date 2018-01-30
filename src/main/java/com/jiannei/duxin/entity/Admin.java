package com.jiannei.duxin.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 管理员表
 * </p>
 * @author Songbw
 * @since 2018-01-30
 */
public class Admin implements Serializable {

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
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 父关联ID
     */
    private String parentIds;
    /**
     * 冻结/激活（0：激活，1：冻结）
     */
    private Integer locked;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
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
        return "Admin{" +
        ", id=" + id +
        ", name=" + name +
        ", username=" + username +
        ", password=" + password +
        ", mobile=" + mobile +
        ", email=" + email +
        ", roleId=" + roleId +
        ", parentId=" + parentId +
        ", parentIds=" + parentIds +
        ", locked=" + locked +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
