package com.jiannei.duxin.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * <p>
 * dealer表
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */
public class Dealer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * dealerID
     */
    private Long id;
    /**
     * 负责人名称
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
     * 公司名
     */
    private String companyName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 创建者ID
     */
    private Long adminId;
    /**
     * 省份CODE
     */
    private String provinceCode;
    /**
     * 城市CODE
     */
    private String cityCode;
    /**
     * 地区CODE
     */
    private String areaCode;
    /**
     * 地址
     */
    private String address;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 激活/冻结 （0：激活，1：冻结）
     */
    private Integer locked;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 邀请码
     */
    private String inviteCode;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
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
        return "Dealer{" +
        ", id=" + id +
        ", name=" + name +
        ", username=" + username +
        ", password=" + password +
        ", companyName=" + companyName +
        ", mobile=" + mobile +
        ", telephone=" + telephone +
        ", adminId=" + adminId +
        ", provinceCode=" + provinceCode +
        ", cityCode=" + cityCode +
        ", areaCode=" + areaCode +
        ", address=" + address +
        ", roleId=" + roleId +
        ", locked=" + locked +
        ", email=" + email +
        ", inviteCode=" + inviteCode +
        ", createdAt=" + createdAt +
        ", updatedAt=" + updatedAt +
        "}";
    }
}
