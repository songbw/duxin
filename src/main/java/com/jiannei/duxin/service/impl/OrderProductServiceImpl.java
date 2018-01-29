package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.OrderProduct;
import com.jiannei.duxin.dao.OrderProductMapper;
import com.jiannei.duxin.service.IOrderProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.OrderProductQueryBean;
import com.jiannei.duxin.dto.OrderProductDTO;

import java.util.*;

import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;

import java.util.List;

/**
 * <p>
 * 货单产品表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Service("IOrderProductService")
public class OrderProductServiceImpl implements IOrderProductService {

    @Autowired
    private OrderProductMapper mapper;

        @Override
        public ResultBean insert(OrderProductDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            OrderProduct entity = new OrderProduct();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(OrderProductDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            OrderProduct entity = mapper.selectById(dto.getId());
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
            OrderProduct entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(OrderProductQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<OrderProduct> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
            if (!StringUtils.isEmpty(queryBean.getOrderId())) {
                map.put("orderId", new StringBuilder("%").append(queryBean.getOrderId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getProductOrder())) {
                map.put("productOrder", new StringBuilder("%").append(queryBean.getProductOrder()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getName())) {
                map.put("name", new StringBuilder("%").append(queryBean.getName()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getSpecification())) {
                map.put("specification", new StringBuilder("%").append(queryBean.getSpecification()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getHardness())) {
                map.put("hardness", new StringBuilder("%").append(queryBean.getHardness()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getTexture())) {
                map.put("texture", new StringBuilder("%").append(queryBean.getTexture()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getColor())) {
                map.put("color", new StringBuilder("%").append(queryBean.getColor()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCustomerWeight())) {
                map.put("customerWeight", new StringBuilder("%").append(queryBean.getCustomerWeight()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getWeight())) {
                map.put("weight", new StringBuilder("%").append(queryBean.getWeight()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getRemark())) {
                map.put("remark", new StringBuilder("%").append(queryBean.getRemark()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getStatus())) {
                map.put("status", new StringBuilder("%").append(queryBean.getStatus()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getPriority())) {
                map.put("priority", new StringBuilder("%").append(queryBean.getPriority()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCreatedAt())) {
                map.put("createdAt", new StringBuilder("%").append(queryBean.getCreatedAt()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getUpdatedAt())) {
                map.put("updatedAt", new StringBuilder("%").append(queryBean.getUpdatedAt()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCustomerId())) {
                map.put("customerId", new StringBuilder("%").append(queryBean.getCustomerId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getDealerId())) {
                map.put("dealerId", new StringBuilder("%").append(queryBean.getDealerId()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getPrice())) {
                map.put("price", new StringBuilder("%").append(queryBean.getPrice()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getTotalPrice())) {
                map.put("totalPrice", new StringBuilder("%").append(queryBean.getTotalPrice()).append("%").toString());
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
            OrderProduct entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
