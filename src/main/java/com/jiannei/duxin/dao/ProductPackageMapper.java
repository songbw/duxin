package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.ProductPackage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品打包列表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface ProductPackageMapper {

    int add(ProductPackage entity);

    int update(ProductPackage entity);

    int delete(int id);

    ProductPackage selectById(Long id);

    List<ProductPackage> selectAllByPage(Map map);

    int selectAllBySize(Map map);
}
