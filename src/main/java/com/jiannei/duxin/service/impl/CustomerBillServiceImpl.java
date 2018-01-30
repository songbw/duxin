package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.CustomerBill;
import com.jiannei.duxin.dao.CustomerBillMapper;
import com.jiannei.duxin.service.ICustomerBillService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.CustomerBillQueryBean;
import com.jiannei.duxin.dto.CustomerBillDTO;
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
@Service("ICustomerBillService")
public class CustomerBillServiceImpl implements ICustomerBillService {

    @Autowired
    private CustomerBillMapper mapper;

        @Override
        public ResultBean insert(CustomerBillDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            CustomerBill entity = new CustomerBill();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(CustomerBillDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            CustomerBill entity = mapper.selectById(dto.getId());
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
            CustomerBill entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(CustomerBillQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<CustomerBill> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
            if (!StringUtils.isEmpty(queryBean.getDealerId())) {
                map.put("dealerId", new StringBuilder("%").append(queryBean.getDealerId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCustomerId())) {
                map.put("customerId", new StringBuilder("%").append(queryBean.getCustomerId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCustomerName())) {
                map.put("customerName", new StringBuilder("%").append(queryBean.getCustomerName()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCustomerPhone())) {
                map.put("customerPhone", new StringBuilder("%").append(queryBean.getCustomerPhone()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getOrderId())) {
                map.put("orderId", new StringBuilder("%").append(queryBean.getOrderId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getTotalPrice())) {
                map.put("totalPrice", new StringBuilder("%").append(queryBean.getTotalPrice()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getActualPrice())) {
                map.put("actualPrice", new StringBuilder("%").append(queryBean.getActualPrice()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getPaid())) {
                map.put("paid", new StringBuilder("%").append(queryBean.getPaid()).append("%").toString());
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
            CustomerBill entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
