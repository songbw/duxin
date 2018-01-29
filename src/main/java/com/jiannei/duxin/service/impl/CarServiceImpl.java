package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.Car;
import com.jiannei.duxin.dao.CarMapper;
import com.jiannei.duxin.service.ICarService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.CarQueryBean;
import com.jiannei.duxin.dto.CarDTO;

import java.util.*;

import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;

import java.util.List;

/**
 * <p>
 * 车辆信息表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Service("ICarService")
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarMapper mapper;

        @Override
        public ResultBean insert(CarDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Car entity = new Car();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(CarDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Car entity = mapper.selectById(dto.getId());
            if (entity != null) {
                BeanUtils.copyProperties(dto,entity);
                int id = mapper.update(entity) ;
                resultBean.setSucResult(id);
            }
            return resultBean;
        }

        @Override
        public ResultBean delete(int id) throws Exception {
            ResultBean resultBean = new ResultBean();
            Car entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(CarQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<Car> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
            if (!StringUtils.isEmpty(queryBean.getUserId())) {
                map.put("userId", new StringBuilder("%").append(queryBean.getUserId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getUserType())) {
                map.put("userType", new StringBuilder("%").append(queryBean.getUserType()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCarNumber())) {
                map.put("carNumber", new StringBuilder("%").append(queryBean.getCarNumber()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getDesc())) {
                map.put("desc", new StringBuilder("%").append(queryBean.getDesc()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCreatedAt())) {
                map.put("createdAt", new StringBuilder("%").append(queryBean.getCreatedAt()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getUpdatedAt())) {
                map.put("updatedAt", new StringBuilder("%").append(queryBean.getUpdatedAt()).append("%").toString());
            }
            int total = 0;

            entityList = mapper.selectAllByPage(map) ;
            total = mapper.selectAllBySize(map);
            PageBean pageBean = new PageBean();
            pageBean.setList(entityList);
            pageBean.setTotal(total);
            pageBean.setPages(PageBean.getPages(total, queryBean.getPageSize()));
            pageBean.setPageNo(queryBean.getPageNo());
            pageBean.setPageSize(queryBean.getPageSize());
            resultBean.setSucResult(pageBean);
            return resultBean;
        }

        @Override
        public ResultBean get(int id) throws Exception {
            ResultBean resultBean = new ResultBean();
            Car entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
