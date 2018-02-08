package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.OrderProductQueryBean;
import com.jiannei.duxin.dto.OrderProductDTO;

/**
 * <p>
 * 货单产品表 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface IOrderProductService {

    ResultBean insert(OrderProductDTO dto) throws Exception;

    ResultBean update(OrderProductDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(OrderProductQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

}
