package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.CustomerBill;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface CustomerBillMapper {

    int add(CustomerBill entity);

    int update(CustomerBill entity);

    int delete(int id);

    CustomerBill selectById(Long id);

    List<CustomerBill> selectAllByPage(Map map);

    int selectAllBySize(Map map);
}
