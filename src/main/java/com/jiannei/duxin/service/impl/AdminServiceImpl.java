package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.dto.SystemStatus;
import com.jiannei.duxin.entity.Admin;
import com.jiannei.duxin.dao.AdminMapper;
import com.jiannei.duxin.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.AdminQueryBean;
import com.jiannei.duxin.dto.AdminDTO;
import java.util.*;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
import java.util.List;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("IAdminService")
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminMapper mapper;

        @Override
        public ResultBean insert(AdminDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Admin entity = mapper.selectByUsername(dto.getUsername()) ;
            if (entity == null) {
                BeanUtils.copyProperties(dto,entity);
                int id = mapper.add(entity) ;
                resultBean.setSucResult(id);
            } else {
                resultBean.setFailMsg(SystemStatus.USERNAME_EXIST);
            }
            return resultBean;
        }

        @Override
        public ResultBean update(AdminDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Admin entity = mapper.selectById(dto.getId());
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
            Admin entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(AdminQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<Admin> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
            if (!StringUtils.isEmpty(queryBean.getName())) {
                map.put("name", new StringBuilder("%").append(queryBean.getName()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getUsername())) {
                map.put("username", new StringBuilder("%").append(queryBean.getUsername()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getPassword())) {
                map.put("password", new StringBuilder("%").append(queryBean.getPassword()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getMobile())) {
                map.put("mobile", new StringBuilder("%").append(queryBean.getMobile()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getEmail())) {
                map.put("email", new StringBuilder("%").append(queryBean.getEmail()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getRoleId())) {
                map.put("roleId", new StringBuilder("%").append(queryBean.getRoleId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getParentId())) {
                map.put("parentId", new StringBuilder("%").append(queryBean.getParentId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getParentIds())) {
                map.put("parentIds", new StringBuilder("%").append(queryBean.getParentIds()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getLocked())) {
                map.put("locked", new StringBuilder("%").append(queryBean.getLocked()).append("%").toString());
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
            Admin entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
