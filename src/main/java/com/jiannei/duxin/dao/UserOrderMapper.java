package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.UserOrder;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 货单表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface UserOrderMapper {

    int add(UserOrder entity);

    int update(UserOrder entity);

    int delete(int id);

    UserOrder selectById(Long id);

    List<UserOrder> selectAllByPage(Map map);

    int selectAllBySize(Map map);
}
