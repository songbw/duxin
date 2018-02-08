package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.dao.UserTokenMapper;
import com.jiannei.duxin.dto.*;
import com.jiannei.duxin.entity.UserToken;
import com.jiannei.duxin.entity.Worker;
import com.jiannei.duxin.dao.WorkerMapper;
import com.jiannei.duxin.service.IWorkerService;
import com.jiannei.duxin.utils.DateUtils;
import com.jiannei.duxin.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.query.WorkerQueryBean;

import java.util.*;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 工人表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("IWorkerService")
public class WorkerServiceImpl implements IWorkerService {

    @Autowired
    private WorkerMapper mapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public ResultBean insert(WorkerDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Worker entity = new Worker();
        BeanUtils.copyProperties(dto, entity);
        int id = mapper.add(entity);
        resultBean.setSucResult(id);
        return resultBean;
    }

    @Override
    public ResultBean update(WorkerDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Worker entity = mapper.selectById(dto.getId());
        if (entity != null) {
            BeanUtils.copyProperties(dto, entity);
            int id = mapper.update(entity);
            resultBean.setSucResult(id);
        }
        return resultBean;
    }

    @Override
    public ResultBean updateLocked(WorkerDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Worker entity = mapper.selectById(dto.getId());
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
    public ResultBean updatePasswd(WorkerDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Worker entity = mapper.selectById(dto.getId());
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
        Worker entity = mapper.selectById((long) id);
        if (entity != null) {
            int result = mapper.delete(id);
            resultBean.setSucResult(result);
        }
        return resultBean;
    }

    @Override
    public ResultBean listByPage(WorkerQueryBean queryBean) throws Exception {
        ResultBean resultBean = new ResultBean();
        List<Worker> entityList = new ArrayList<>();
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
        if (!StringUtils.isEmpty(queryBean.getGender())) {
            map.put("gender", new StringBuilder("%").append(queryBean.getGender()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getBirthDate())) {
            map.put("birthDate", new StringBuilder("%").append(queryBean.getBirthDate()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getMobile())) {
            map.put("mobile", new StringBuilder("%").append(queryBean.getMobile()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getNativePlace())) {
            map.put("nativePlace", new StringBuilder("%").append(queryBean.getNativePlace()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getDealerId())) {
            map.put("dealerId", new StringBuilder("%").append(queryBean.getDealerId()).append("%").toString());
        }
        if (!StringUtils.isEmpty(queryBean.getWorkType())) {
            map.put("workType", new StringBuilder("%").append(queryBean.getWorkType()).append("%").toString());
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
        Worker entity = mapper.selectById((long) id);
        resultBean.setSucResult(entity);
        return resultBean;
    }

    @Override
    public ResultBean login(WorkerDTO dto) throws Exception {
        ResultBean resultBean = new ResultBean();
        Worker entity = mapper.selectByUsername(dto.getUsername());
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
                    userToken.setUserType(UserTypeEnum.WORKER.getValue());
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
        userToken.setUserType(UserTypeEnum.WORKER.getValue());
        int id = userTokenMapper.deleteByRefreshToken(userToken);
        resultBean.setSucResult(id);
        return resultBean;
    }

    @Override
    public ResultBean getUserByToken(String token) throws Exception {
        ResultBean resultBean = new ResultBean();
        Worker entity = mapper.selectUserByToken(token);
        resultBean.setSucResult(entity);
        return resultBean;
    }
}
