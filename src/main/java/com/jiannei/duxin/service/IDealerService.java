package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.DealerQueryBean;
import com.jiannei.duxin.dto.DealerDTO;

/**
 * <p>
 * dealer表 服务类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface IDealerService {

    ResultBean insert(DealerDTO dto) throws Exception;

    ResultBean update(DealerDTO dto) throws Exception;

    ResultBean updateLocked(DealerDTO dto) throws Exception;

    ResultBean updatePasswd(DealerDTO dto) throws Exception;

    ResultBean delete(int id) throws Exception;

    ResultBean listByPage(DealerQueryBean queryBean) throws Exception;

    ResultBean get(int id) throws Exception;

    ResultBean login(DealerDTO dto) throws Exception;

    ResultBean logout(String refreshToken) throws Exception;

    ResultBean getUserByToken(String token) throws Exception;

}
