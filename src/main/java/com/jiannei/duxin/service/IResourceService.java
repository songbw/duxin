package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ResourceQueryBean;
import com.jiannei.duxin.dto.ResourceDTO;

/**
 * <p>
 * 资源表 服务类
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */
public interface IResourceService {

        ResultBean insert(ResourceDTO dto) throws Exception;

        ResultBean update(ResourceDTO dto) throws Exception;

        ResultBean delete(int id) throws Exception;

        ResultBean listByPage(ResourceQueryBean queryBean) throws Exception;

        ResultBean get(int id) throws Exception;

}
