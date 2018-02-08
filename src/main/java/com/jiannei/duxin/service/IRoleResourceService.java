package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.RoleResourceQueryBean;
import com.jiannei.duxin.dto.RoleResourceDTO;

/**
 * <p>
 * 角色资源表 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface IRoleResourceService {

    ResultBean insert(RoleResourceDTO dto) throws Exception;

    ResultBean update(RoleResourceDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(RoleResourceQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

    ResultBean getByRole(long roleId) throws Exception;

}
