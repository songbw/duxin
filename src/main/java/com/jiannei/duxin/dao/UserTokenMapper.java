package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.UserToken;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface UserTokenMapper{

        int add(UserToken entity) ;

        int update(UserToken entity) ;

        int delete(int id);

        int deleteByRefreshToken(UserToken entity);

        UserToken selectById(Long id);

        UserToken selectByUserId(UserToken entity);

        List<UserToken> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
