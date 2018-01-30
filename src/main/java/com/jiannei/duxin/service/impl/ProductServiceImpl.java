package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.Product;
import com.jiannei.duxin.dao.ProductMapper;
import com.jiannei.duxin.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ProductQueryBean;
import com.jiannei.duxin.dto.ProductDTO;
import java.util.*;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
import java.util.List;

/**
 * <p>
 * 产品信息表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-30
 */
@Service("IProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper mapper;

        @Override
        public ResultBean insert(ProductDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Product entity = new Product();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(ProductDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            Product entity = mapper.selectById(dto.getId());
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
            Product entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(ProductQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<Product> entityList = new ArrayList<>();
            int offset = PageBean.getOffset(queryBean.getPageNo(), queryBean.getPageSize());
            HashMap map = new HashMap();
            map.put("pageNo", offset);
            map.put("pageSize", queryBean.getPageSize());
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
            if (!StringUtils.isEmpty(queryBean.getRemark())) {
                map.put("remark", new StringBuilder("%").append(queryBean.getRemark()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCreatedAt())) {
                map.put("createdAt", new StringBuilder("%").append(queryBean.getCreatedAt()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getUpdatedAt())) {
                map.put("updatedAt", new StringBuilder("%").append(queryBean.getUpdatedAt()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getCreator())) {
                map.put("creator", new StringBuilder("%").append(queryBean.getCreator()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getPrice())) {
                map.put("price", new StringBuilder("%").append(queryBean.getPrice()).append("%").toString());
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
            Product entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
