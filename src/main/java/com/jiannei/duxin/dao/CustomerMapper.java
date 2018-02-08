package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface CustomerMapper {

    int add(Customer entity);

    int update(Customer entity);

    int delete(int id);

    Customer selectById(Long id);

    List<Customer> selectAllByPage(Map map);

    int selectAllBySize(Map map);
}
