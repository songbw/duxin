package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface ResourceMapper{

        int add(Resource entity) ;

        int update(Resource entity) ;

        int delete(int id);

        Resource selectById(Long id);

        List<Resource> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
