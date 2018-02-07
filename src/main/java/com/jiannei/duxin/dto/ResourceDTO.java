package com.jiannei.duxin.dto;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */

public class ResourceDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    /**
     * 名称
     */

    private String name;
    /**
     * 类型（栏目，menu,按钮）
     */

    private String type;
    /**
     * 相对路径
     */

    private String url;
    /**
     * 显示顺序
     */

    private Integer priority;
    /**
     * 父ID
     */

    private Long parentId = 0l;
    /**
     * 父ID列表
     */

    private String parentIds = "0,";
    /**
     * 权限字符串
     */

    private String permission;
    /**
     * 是否可用（0：可用，1：不可以）
     */

    private Integer available = 0;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
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
