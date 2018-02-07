package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.dao.RoleResourceMapper;
import com.jiannei.duxin.dto.*;
import com.jiannei.duxin.entity.Role;
import com.jiannei.duxin.dao.RoleMapper;
import com.jiannei.duxin.entity.RoleResource;
import com.jiannei.duxin.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.query.RoleQueryBean;

import java.util.*;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("IRoleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper mapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public ResultBean insert(RoleDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Role entity = new Role();
        entity.setName(dto.getName());
        entity.setAdminId(dto.getAdminId());
        entity = mapper.selectByName(entity);
        if (entity == null) {
            entity = new Role();
            BeanUtils.copyProperties(dto, entity);
            mapper.add(entity);

            List<RoleResourceDTO> roleResourceDTOS = dto.getRoleResourceDTOS();
            for (RoleResourceDTO roleResourceDTO : roleResourceDTOS) {
                RoleResource roleResource = new RoleResource();
                roleResource.setRoleId(entity.getId());
                roleResource.setResId(roleResourceDTO.getResId());
                roleResourceMapper.add(roleResource);
            }
            resultBean.setSucResult(entity.getId());
        } else {
            resultBean.setFailMsg(SystemStatus.NAME_EXIST);
        }
        return resultBean;
    }

    @Override
    public ResultBean update(RoleDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Role entity = mapper.selectById(dto.getId());
        if (entity != null) {
            Role temp = new Role();
            temp.setAdminId(dto.getAdminId());
            temp.setName(dto.getName());
            temp = mapper.selectByName(temp);
            if (null != temp && temp.getId() != dto.getId()) {
                resultBean.setFailMsg(SystemStatus.NAME_EXIST);
                return resultBean;
            }
            BeanUtils.copyProperties(dto, entity);
            mapper.update(entity);

            List<RoleResourceDTO> roleResourceDTOS = dto.getRoleResourceDTOS();
            if (roleResourceDTOS.size() > 0) {
                roleResourceMapper.deleteByRoleId(entity.getId());
            }
            for (RoleResourceDTO roleResourceDTO : roleResourceDTOS) {
                RoleResource roleResource = new RoleResource();
                roleResource.setRoleId(entity.getId());
                roleResource.setResId(roleResourceDTO.getResId());
                roleResourceMapper.add(roleResource);
            }
            resultBean.setSucResult(entity.getId());
        } else {
            resultBean.setFailMsg(SystemStatus.NAME_NO_EXIST);
        }
        return resultBean;
    }

    @Override
    public ResultBean delete(int id) throws Exception {
        ResultBean resultBean = new ResultBean();
        Role entity = mapper.selectById((long) id);
        if (entity != null) {
            int result = mapper.delete(id);
            resultBean.setSucResult(result);
        }
        return resultBean;
    }

    @Override
    public ResultBean listByPage(RoleQueryBean queryBean) throws Exception {
        ResultBean resultBean = new ResultBean();
        List<Role> entityList = new ArrayList<>();
        int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
        HashMap map = new HashMap();
        map.put("pageNo", offset);
        map.put("pageSize", queryBean.getPageSize());
        if (!StringUtils.isEmpty(queryBean.getName())) {
            map.put("name", new StringBuilder("%").append(queryBean.getName()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getRemark())) {
            map.put("remark", new StringBuilder("%").append(queryBean.getRemark()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getCreatedAt())) {
            map.put("createdAt", new StringBuilder("%").append(queryBean.getCreatedAt()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getUpdatedAt())) {
            map.put("updatedAt", new StringBuilder("%").append(queryBean.getUpdatedAt()).append("%").toString());
        }
        int total = 0;

        entityList = mapper.selectAllByPage(map);
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
        Role entity = mapper.selectById((long) id);
        resultBean.setSucResult(entity);
        return resultBean;
    }
}
