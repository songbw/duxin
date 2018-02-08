package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.CustomerQueryBean;
import com.jiannei.duxin.dto.CustomerDTO;

/**
 * <p>
 * 客户表 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface ICustomerService {

    ResultBean insert(CustomerDTO dto) throws Exception;

    ResultBean update(CustomerDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(CustomerQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

}
