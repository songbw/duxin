package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Worker;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 工人表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface WorkerMapper{

        int add(Worker entity) ;

        int update(Worker entity) ;

        int delete(int id);

        Worker selectById(Long id);

        List<Worker> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
