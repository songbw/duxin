package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ProductPackageQueryBean;
import com.jiannei.duxin.dto.ProductPackageDTO;

/**
 * <p>
 * 产品打包列表 服务类
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */
public interface IProductPackageService {

        ResultBean insert(ProductPackageDTO dto) throws Exception;

        ResultBean update(ProductPackageDTO dto) throws Exception;

        ResultBean delete(int id) throws Exception;

        ResultBean listByPage(ProductPackageQueryBean queryBean) throws Exception;

        ResultBean get(int id) throws Exception;

}
