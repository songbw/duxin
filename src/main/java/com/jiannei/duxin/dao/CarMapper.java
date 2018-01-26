package com.jiannei.duxin.dao;

import com.jiannei.duxin.entity.Car;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 车辆信息表 Mapper 接口
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
public interface CarMapper{

        int add(Car entity) ;

        int update(Car entity) ;

        int delete(int id);

        Car selectById(Long id);

        List<Car> selectAllByPage(Map map) ;

        int selectAllBySize(Map map);
}
