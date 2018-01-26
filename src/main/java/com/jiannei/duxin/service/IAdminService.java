package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.AdminQueryBean;
import com.jiannei.duxin.dto.AdminDTO;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */
public interface IAdminService {

        ResultBean insert(AdminDTO dto) throws Exception;

        ResultBean update(AdminDTO dto) throws Exception;

        ResultBean delete(int id) throws Exception;

        ResultBean listByPage(AdminQueryBean queryBean) throws Exception;

        ResultBean get(int id) throws Exception;

}
