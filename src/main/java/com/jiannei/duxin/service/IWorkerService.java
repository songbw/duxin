package com.jiannei.duxin.service;

import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.WorkerQueryBean;
import com.jiannei.duxin.dto.WorkerDTO;

/**
 * <p>
 * 工人表 服务类
 * </p>
 * @author Songbw
 * @since 2018-01-26
 */
public interface IWorkerService {

        ResultBean insert(WorkerDTO dto) throws Exception;

        ResultBean update(WorkerDTO dto) throws Exception;

        ResultBean delete(int id) throws Exception;

        ResultBean listByPage(WorkerQueryBean queryBean) throws Exception;

        ResultBean get(int id) throws Exception;

}
