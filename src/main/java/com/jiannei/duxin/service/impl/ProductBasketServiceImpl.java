package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.ProductBasket;
import com.jiannei.duxin.dao.ProductBasketMapper;
import com.jiannei.duxin.service.IProductBasketService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ProductBasketQueryBean;
import com.jiannei.duxin.dto.ProductBasketDTO;
import java.util.*;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
import java.util.List;

/**
 * <p>
 * 产品分拣表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("IProductBasketService")
public class ProductBasketServiceImpl implements IProductBasketService {

    @Autowired
    private ProductBasketMapper mapper;

        @Override
        public ResultBean insert(ProductBasketDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            ProductBasket entity = new ProductBasket();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(ProductBasketDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            ProductBasket entity = mapper.selectById(dto.getId());
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
            ProductBasket entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(ProductBasketQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<ProductBasket> entityList = new ArrayList<>();
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
            if (!StringUtils.isEmpty(queryBean.getBasketNum())) {
                map.put("basketNum", new StringBuilder("%").append(queryBean.getBasketNum()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getSortUser())) {
                map.put("sortUser", new StringBuilder("%").append(queryBean.getSortUser()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getArea())) {
                map.put("area", new StringBuilder("%").append(queryBean.getArea()).append("%").toString());
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
            ProductBasket entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
