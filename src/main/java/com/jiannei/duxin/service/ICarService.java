package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.CarQueryBean;
import com.jiannei.duxin.dto.CarDTO;

/**
 * <p>
 * 车辆信息表 服务类
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */
public interface ICarService {

        ResultBean insert(CarDTO dto) throws Exception;

        ResultBean update(CarDTO dto) throws Exception;

        ResultBean delete(int id) throws Exception;

        ResultBean listByPage(CarQueryBean queryBean) throws Exception;

        ResultBean get(int id) throws Exception;

}
