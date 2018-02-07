package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Dealer;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * dealer表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface DealerMapper {

    int add(Dealer entity);

    int update(Dealer entity);

    int delete(int id);

    Dealer selectById(Long id);

    List<Dealer> selectAllByPage(Map map);

    int selectAllBySize(Map map);

    Dealer selectByUsername(String username);

    Dealer selectByMobile(String mobile);

    int updateLocked(Dealer entity);

    int updatePasswd(Dealer entity);

    Dealer selectUserByToken(String token);
}
