package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.UserToken;
import com.jiannei.duxin.dao.UserTokenMapper;
import com.jiannei.duxin.service.IUserTokenService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.UserTokenQueryBean;
import com.jiannei.duxin.dto.UserTokenDTO;
import java.util.*;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("IUserTokenService")
public class UserTokenServiceImpl implements IUserTokenService {

    @Autowired
    private UserTokenMapper mapper;

        @Override
        public ResultBean insert(UserTokenDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            UserToken entity = new UserToken();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(UserTokenDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            UserToken entity = mapper.selectById(dto.getId());
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
            UserToken entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(UserTokenQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<UserToken> entityList = new ArrayList<>();
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
            if (!StringUtils.isEmpty(queryBean.getAccessToken())) {
                map.put("accessToken", new StringBuilder("%").append(queryBean.getAccessToken()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getRefreshToken())) {
                map.put("refreshToken", new StringBuilder("%").append(queryBean.getRefreshToken()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getExpired())) {
                map.put("expired", new StringBuilder("%").append(queryBean.getExpired()).append("%").toString());
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
            UserToken entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
