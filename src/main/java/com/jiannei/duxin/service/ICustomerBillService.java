package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.CustomerBillQueryBean;
import com.jiannei.duxin.dto.CustomerBillDTO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface ICustomerBillService {

    ResultBean insert(CustomerBillDTO dto) throws Exception;

    ResultBean update(CustomerBillDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(CustomerBillQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

}
