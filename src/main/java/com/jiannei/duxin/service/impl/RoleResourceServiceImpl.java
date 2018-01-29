package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.RoleResource;
import com.jiannei.duxin.dao.RoleResourceMapper;
import com.jiannei.duxin.service.IRoleResourceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.RoleResourceQueryBean;
import com.jiannei.duxin.dto.RoleResourceDTO;

import java.util.*;

import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;

import java.util.List;

/**
 * <p>
 * 角色资源表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Service("IRoleResourceService")
public class RoleResourceServiceImpl implements IRoleResourceService {

    @Autowired
    private RoleResourceMapper mapper;

        @Override
        public ResultBean insert(RoleResourceDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            RoleResource entity = new RoleResource();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(RoleResourceDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            RoleResource entity = mapper.selectById(dto.getId());
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
            RoleResource entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(RoleResourceQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<RoleResource> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
            if (!StringUtils.isEmpty(queryBean.getRoleId())) {
                map.put("roleId", new StringBuilder("%").append(queryBean.getRoleId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getResId())) {
                map.put("resId", new StringBuilder("%").append(queryBean.getResId()).append("%").toString());
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
            RoleResource entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
