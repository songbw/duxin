package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.OrderProduct;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 货单产品表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface OrderProductMapper {

    int add(OrderProduct entity);

    int update(OrderProduct entity);

    int delete(int id);

    OrderProduct selectById(Long id);

    List<OrderProduct> selectAllByPage(Map map);

    int selectAllBySize(Map map);
}
