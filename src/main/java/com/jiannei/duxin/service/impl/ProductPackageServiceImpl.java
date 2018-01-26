package com.jiannei.duxin.service.impl;

import com.jiannei.duxin.entity.ProductPackage;
import com.jiannei.duxin.dao.ProductPackageMapper;
import com.jiannei.duxin.service.IProductPackageService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ProductPackageQueryBean;
import com.jiannei.duxin.dto.ProductPackageDTO;
import java.util.List;
import java.util.Map;
import org.springframework.util.StringUtils;
import com.jiannei.duxin.dto.PageBean;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 产品打包列表 服务实现类
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Service("IProductPackageService")
public class ProductPackageServiceImpl implements IProductPackageService {

    @Autowired
    private ProductPackageMapper mapper;

        @Override
        public ResultBean insert(ProductPackageDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            ProductPackage entity = new ProductPackage();
            BeanUtils.copyProperties(dto,entity);
            int id = mapper.add(entity) ;
            resultBean.setSucResult(id);
            return resultBean;
        }

        @Override
        public ResultBean update(ProductPackageDTO dto) throws Exception {
            ResultBean resultBean = new ResultBean();
            ProductPackage entity = mapper.selectById(dto.getId());
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
            ProductPackage entity = mapper.selectById((long) id) ;
            if (entity != null) {
                int result = mapper.delete(id) ;
                resultBean.setSucResult(result);
            }
            return resultBean;
        }

        @Override
        public ResultBean listByPage(ProductPackageQueryBean queryBean) throws Exception {
            ResultBean resultBean = new ResultBean();
            List<ProductPackage> entityList = new ArrayList<>();
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
            if (!StringUtils.isEmpty(queryBean.getPackageNum())) {
                map.put("packageNum", new StringBuilder("%").append(queryBean.getPackageNum()).append("%").toString());
            }
            if (!StringUtils.isEmpty(queryBean.getPackageWeight())) {
                map.put("packageWeight", new StringBuilder("%").append(queryBean.getPackageWeight()).append("%").toString());
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
            if (!StringUtils.isEmpty(queryBean.getStatus())) {
                map.put("status", new StringBuilder("%").append(queryBean.getStatus()).append("%").toString());
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
            ProductPackage entity = mapper.selectById((long) id) ;
            resultBean.setSucResult(entity);
            return resultBean;
        }
}
