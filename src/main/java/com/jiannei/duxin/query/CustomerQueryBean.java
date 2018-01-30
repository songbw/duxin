package com.jiannei.duxin.query;

import java.util.Date;
import java.math.BigDecimal;



/**
 * <p>
 * 客户表
 * </p>
 * @author Songbw
 * @since 2018-01-30
 */

public class CustomerQueryBean extends QueryBean {

    /**
     * ID
     */

    private Long id;
    /**
     * 名称
     */

    private String name;
    /**
     * 性别
     */

    private String gender;
    /**
     * 出生日期
     */

    private Date birthDate;
    /**
     * 手机号
     */

    private String mobile;
    /**
     * 电话
     */

    private String telephone;
    /**
     * 密码
     */

    private String password;
    /**
     * 地址
     */

    private String address;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
