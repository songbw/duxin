package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.UserOrder;
import com.jiannei.duxin.dao.UserOrderMapper;
import com.jiannei.duxin.service.IUserOrderService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.UserOrderQueryBean;
import com.jiannei.duxin.dto.UserOrderDTO;
import java.util.List;
import java.util.Map;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 货单表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Service("IUserOrderService")
public class UserOrderServiceImpl implements IUserOrderService {

    @Autowired
    private UserOrderMapper mapper;

        @Override
        public ResultBean insert(UserOrderDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            UserOrder entity = new UserOrder();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(UserOrderDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            UserOrder entity = mapper.selectById(dto.getId());
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
            UserOrder entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(UserOrderQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<UserOrder> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
            if (!StringUtils.isEmpty(queryBean.getOrderId())) {
                map.put("orderId", new StringBuilder("%").append(queryBean.getOrderId()).append("%").toString());
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
            if (!StringUtils.isEmpty(queryBean.getCarNumber())) {
                map.put("carNumber", new StringBuilder("%").append(queryBean.getCarNumber()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getTotalWeight())) {
                map.put("totalWeight", new StringBuilder("%").append(queryBean.getTotalWeight()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCarWeight())) {
                map.put("carWeight", new StringBuilder("%").append(queryBean.getCarWeight()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getStatus())) {
                map.put("status", new StringBuilder("%").append(queryBean.getStatus()).append("%").toString());
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
            if (!StringUtils.isEmpty(queryBean.getDealerId())) {
                map.put("dealerId", new StringBuilder("%").append(queryBean.getDealerId()).append("%").toString());
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
            UserOrder entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
