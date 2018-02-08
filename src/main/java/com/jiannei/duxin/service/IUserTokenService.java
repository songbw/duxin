package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.UserTokenQueryBean;
import com.jiannei.duxin.dto.UserTokenDTO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface IUserTokenService {

    ResultBean insert(UserTokenDTO dto) throws Exception;

    ResultBean update(UserTokenDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(UserTokenQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

}
