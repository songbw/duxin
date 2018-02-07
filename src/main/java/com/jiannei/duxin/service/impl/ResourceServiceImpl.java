package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.dto.SystemStatus;
import com.jiannei.duxin.entity.Resource;
import com.jiannei.duxin.dao.ResourceMapper;
import com.jiannei.duxin.service.IResourceService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ResourceQueryBean;
import com.jiannei.duxin.dto.ResourceDTO;

import java.util.*;

import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;

import java.util.List;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("IResourceService")
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper mapper;

    @Override
    public ResultBean insert(ResourceDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Resource entity = mapper.selectByName(dto.getName());
        if (entity == null) {
            entity = new Resource();
            BeanUtils.copyProperties(dto, entity);
            if (entity.getParentId() != 0l) {
                Resource temp = mapper.selectById(entity.getParentId());
                if (temp != null) {
                    entity.setParentIds(temp.getParentIds());
                } else {
                    resultBean.setFailMsg(SystemStatus.PARENT_NO_EXIST);
                    return resultBean;
                }
            }
            mapper.add(entity);
            entity.setParentIds(entity.getParentIds() + entity.getId() + ",");
            mapper.update(entity);
            resultBean.setSucResult(entity.getId());
        } else {
            resultBean.setFailMsg(SystemStatus.NAME_EXIST);
        }
        return resultBean;
    }

    @Override
    public ResultBean update(ResourceDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Resource entity = mapper.selectById(dto.getId());
        if (entity != null) {
            if (null != dto.getName() && !"".equals(dto.getName())) {
                Resource temp = mapper.selectByName(dto.getName());
                if (null != temp && entity.getId() != temp.getId()) {
                    resultBean.setFailMsg(SystemStatus.NAME_EXIST);
                    return resultBean;
                }
            }
            if (dto.getParentId() > 0) {
                Resource temp = mapper.selectById(dto.getParentId());
                dto.setParentIds(temp.getParentIds() + dto.getId() + ",");
            }
            BeanUtils.copyProperties(dto, entity);
            mapper.update(entity);
            resultBean.setSucResult(entity.getId());
        } else {
            resultBean.setFailMsg(SystemStatus.NAME_NO_EXIST);
        }
        return resultBean;
    }

    @Override
    public ResultBean updateAvailable(ResourceDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Resource entity = mapper.selectById(dto.getId());
        if (entity == null) {
            resultBean.setFailMsg(SystemStatus.RESOURCE_NO_EXIST);
            return resultBean;
        }
        if (entity.getAvailable() != dto.getAvailable()) {
            entity.setAvailable(dto.getAvailable());
            mapper.updateAvailable(entity);
            resultBean.setSucResult(entity.getId());
        }
        return resultBean;
    }

    @Override
    public ResultBean delete(int id) throws Exception {
        ResultBean resultBean = new ResultBean();
        Resource entity = mapper.selectById((long) id);
        if (entity != null) {
            int result = mapper.delete(id);
            resultBean.setSucResult(result);
        }
        return resultBean;
    }

    @Override
    public ResultBean listByPage(ResourceQueryBean queryBean) throws Exception {
        ResultBean resultBean = new ResultBean();
        List<Resource> entityList = new ArrayList<>();
        int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
        HashMap map = new HashMap();
        map.put("pageNo", offset);
        map.put("pageSize", queryBean.getPageSize());
        if (!StringUtils.isEmpty(queryBean.getName())) {
            map.put("name", new StringBuilder("%").append(queryBean.getName()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getType())) {
            map.put("type", new StringBuilder("%").append(queryBean.getType()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getUrl())) {
            map.put("url", new StringBuilder("%").append(queryBean.getUrl()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getPriority())) {
            map.put("priority", new StringBuilder("%").append(queryBean.getPriority()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getParentId())) {
            map.put("parentId", new StringBuilder("%").append(queryBean.getParentId()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getParentIds())) {
            map.put("parentIds", new StringBuilder("%").append(queryBean.getParentIds()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getPermission())) {
            map.put("permission", new StringBuilder("%").append(queryBean.getPermission()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getAvailable())) {
            map.put("available", new StringBuilder("%").append(queryBean.getAvailable()).append("%").toString());
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
        Resource entity = mapper.selectById((long) id);
        resultBean.setSucResult(entity);
        return resultBean;
    }
}
