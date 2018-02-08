package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.RoleQueryBean;
import com.jiannei.duxin.dto.RoleDTO;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface IRoleService {

    ResultBean insert(RoleDTO dto) throws Exception;

    ResultBean update(RoleDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(RoleQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

}
