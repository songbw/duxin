package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.UserOrderQueryBean;
import com.jiannei.duxin.dto.UserOrderDTO;

/**
 * <p>
 * 货单表 服务类
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */
public interface IUserOrderService {

        ResultBean insert(UserOrderDTO dto) throws Exception;

        ResultBean update(UserOrderDTO dto) throws Exception;

        ResultBean delete(int id) throws Exception;

        ResultBean listByPage(UserOrderQueryBean queryBean) throws Exception;

        ResultBean get(int id) throws Exception;

}
