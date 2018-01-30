package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.Customer;
import com.jiannei.duxin.dao.CustomerMapper;
import com.jiannei.duxin.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.CustomerQueryBean;
import com.jiannei.duxin.dto.CustomerDTO;
import java.util.*;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
import java.util.List;

/**
 * <p>
 * 客户表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("ICustomerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper mapper;

        @Override
        public ResultBean insert(CustomerDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Customer entity = new Customer();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(CustomerDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Customer entity = mapper.selectById(dto.getId());
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
            Customer entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(CustomerQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<Customer> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
            if (!StringUtils.isEmpty(queryBean.getName())) {
                map.put("name", new StringBuilder("%").append(queryBean.getName()).append("%").toString());
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
            if (!StringUtils.isEmpty(queryBean.getTelephone())) {
                map.put("telephone", new StringBuilder("%").append(queryBean.getTelephone()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getPassword())) {
                map.put("password", new StringBuilder("%").append(queryBean.getPassword()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getAddress())) {
                map.put("address", new StringBuilder("%").append(queryBean.getAddress()).append("%").toString());
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
            Customer entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
