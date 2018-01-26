package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Admin;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface AdminMapper{

        int add(Admin entity) ;

        int update(Admin entity) ;

        int delete(int id);

        Admin selectById(Long id);

        List<Admin> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
