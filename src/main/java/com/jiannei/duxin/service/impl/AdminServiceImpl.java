package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.dao.UserTokenMapper;
import com.jiannei.duxin.dto.*;
import com.jiannei.duxin.entity.Admin;
import com.jiannei.duxin.dao.AdminMapper;
import com.jiannei.duxin.entity.UserToken;
import com.jiannei.duxin.service.IAdminService;
import com.jiannei.duxin.utils.DateUtils;
import com.jiannei.duxin.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.query.AdminQueryBean;

import java.util.*;

import org.springframework.util.StringUtils;

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

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public ResultBean insert(AdminDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Admin entity = mapper.selectByUsername(dto.getUsername());
        if (entity == null) {
            entity = new Admin();
            BeanUtils.copyProperties(dto, entity);
            if (entity.getParentId() != 0l) {
                Admin temp = mapper.selectById(entity.getParentId());
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
            resultBean.setFailMsg(SystemStatus.USERNAME_EXIST);
        }
        return resultBean;
    }

    @Override
    public ResultBean update(AdminDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Admin entity = mapper.selectById(dto.getId());
        if (entity != null) {
            if (null != dto.getUsername() && !"".equals(dto.getUsername())) {
                Admin temp = mapper.selectByUsername(dto.getUsername());
                if (null != temp && entity.getId() != temp.getId()) {
                    resultBean.setFailMsg(SystemStatus.USERNAME_EXIST);
                    return resultBean;
                }
            }
            if (dto.getParentId() > 0) {
                Admin temp = mapper.selectById(dto.getParentId());
                dto.setParentIds(temp.getParentIds() + dto.getId() + ",");
            }
            BeanUtils.copyProperties(dto, entity);
            mapper.update(entity);
            resultBean.setSucResult(entity.getId());
        } else {
            resultBean.setFailMsg(SystemStatus.USERNAME_NO_EXIST);
        }
        return resultBean;
    }

    @Override
    public ResultBean updateLocked(AdminDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Admin entity = mapper.selectById(dto.getId());
        if (entity == null) {
            resultBean.setFailMsg(SystemStatus.USER_NO_EXIST);
            return resultBean;
        }
        if (entity.getLocked() != dto.getLocked()) {
            entity.setLocked(dto.getLocked());
            mapper.updateLocked(entity);
            resultBean.setSucResult(entity.getId());
        }
        return resultBean;
    }

    @Override
    public ResultBean updatePasswd(AdminDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Admin entity = mapper.selectById(dto.getId());
        if (entity == null) {
            resultBean.setFailMsg(SystemStatus.USER_NO_EXIST);
            return resultBean;
        }
        if (entity.getPassword() != dto.getPassword()) {
            entity.setPassword(dto.getPassword());
            mapper.updatePasswd(entity);
            resultBean.setSucResult(entity.getId());
        }
        return resultBean;
    }

    @Override
    public ResultBean delete(int id) throws Exception {
        ResultBean resultBean = new ResultBean();
        Admin entity = mapper.selectById((long) id);
        if (entity != null) {
            int result = mapper.delete(id);
            resultBean.setSucResult(result);
        } else {
            resultBean.setFailMsg(SystemStatus.USERNAME_NO_EXIST);
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
        Admin entity = mapper.selectById((long) id);
        resultBean.setSucResult(entity);
        return resultBean;
    }

    @Override
    public ResultBean login(AdminDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Admin entity = mapper.selectByUsername(dto.getUsername());
        if (entity != null) {
            if (entity.getPassword().equals(dto.getPassword())) {
                UserToken userToken = new UserToken();
                userToken.setUserId(entity.getId());
                userToken.setUserType(1);
                userToken = userTokenMapper.selectByUserId(userToken);
                if (userToken == null) {
                    userToken = new UserToken();
                    String refreshToken = UUID.randomUUID().toString();
                    long expired = DateUtils.addNDay(30);
                    String accessToken = MD5Util.getStringMD5(refreshToken + expired);
                    userToken.setAccessToken(accessToken);
                    userToken.setRefreshToken(refreshToken);
                    userToken.setExpired(expired);
                    userToken.setUserId(entity.getId());
                    userToken.setUserType(UserTypeEnum.ADMIN.getValue());
                    userTokenMapper.add(userToken);
                }
                resultBean.setSucResult(userToken);
            }
        } else {
            resultBean.setFailMsg(SystemStatus.USERNAME_PASSWORD_IS_ERROR);
        }
        return resultBean;
    }

    @Override
    public ResultBean logout(String refreshToken) throws Exception {
        ResultBean resultBean = new ResultBean();
        UserToken userToken = new UserToken();
        userToken.setRefreshToken(refreshToken);
        userToken.setUserType(UserTypeEnum.ADMIN.getValue());
        int id = userTokenMapper.deleteByRefreshToken(userToken);
        resultBean.setSucResult(id);
        return resultBean;
    }

    @Override
    public ResultBean getUserByToken(String token) throws Exception {
        ResultBean resultBean = new ResultBean();
        Admin entity = mapper.selectUserByToken(token);
        resultBean.setSucResult(entity);
        return resultBean;
    }
}
