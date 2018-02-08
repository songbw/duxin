package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ProductQueryBean;
import com.jiannei.duxin.dto.ProductDTO;

/**
 * <p>
 * 产品信息表 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface IProductService {

    ResultBean insert(ProductDTO dto) throws Exception;

    ResultBean update(ProductDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(ProductQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

}
