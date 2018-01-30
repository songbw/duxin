package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.Worker;
import com.jiannei.duxin.dao.WorkerMapper;
import com.jiannei.duxin.service.IWorkerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.WorkerQueryBean;
import com.jiannei.duxin.dto.WorkerDTO;
import java.util.*;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
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

        @Override
        public ResultBean insert(WorkerDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Worker entity = new Worker();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(WorkerDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Worker entity = mapper.selectById(dto.getId());
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
            Worker entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
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
            Worker entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
