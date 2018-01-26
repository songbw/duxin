package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.ProductBasket;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 产品分拣表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface ProductBasketMapper{

        int add(ProductBasket entity) ;

        int update(ProductBasket entity) ;

        int delete(int id);

        ProductBasket selectById(Long id);

        List<ProductBasket> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
