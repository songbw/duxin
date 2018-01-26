package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.RoleResource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色资源表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface RoleResourceMapper{

        int add(RoleResource entity) ;

        int update(RoleResource entity) ;

        int delete(int id);

        RoleResource selectById(Long id);

        List<RoleResource> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
