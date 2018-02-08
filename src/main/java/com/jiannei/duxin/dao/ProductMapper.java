package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品信息表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface ProductMapper {

    int add(Product entity);

    int update(Product entity);

    int delete(int id);

    Product selectById(Long id);

    List<Product> selectAllByPage(Map map);

    int selectAllBySize(Map map);
}
