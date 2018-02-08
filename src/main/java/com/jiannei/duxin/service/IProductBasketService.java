package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ProductBasketQueryBean;
import com.jiannei.duxin.dto.ProductBasketDTO;

/**
 * <p>
 * 产品分拣表 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface IProductBasketService {

    ResultBean insert(ProductBasketDTO dto) throws Exception;

    ResultBean update(ProductBasketDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(ProductBasketQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

}
