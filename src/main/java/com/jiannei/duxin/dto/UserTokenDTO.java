package com.jiannei.duxin.dto;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 * @author Songbw
 * @since 2018-01-30
 */

public class UserTokenDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */

    private Long id;
    /**
     * 用户ID
     */

    private Long userId;
    /**
     * 用户类型
     */

    private Integer userType;
    /**
     * 访问token
     */

    private String accessToken;
    /**
     * 刷新token
     */

    private String refreshToken;
    /**
     * 有效期
     */

    private Long expired;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpired() {
        return expired;
    }

    public void setExpired(Long expired) {
        this.expired = expired;
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
