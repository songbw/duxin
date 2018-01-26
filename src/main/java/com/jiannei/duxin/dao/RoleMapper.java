package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Role;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface RoleMapper{

        int add(Role entity) ;

        int update(Role entity) ;

        int delete(int id);

        Role selectById(Long id);

        List<Role> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
