package com.jiannei.duxin.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jiannei.duxin.service.IProductPackageService;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ProductPackageQueryBean;
import com.jiannei.duxin.dto.ProductPackageDTO;
import com.jiannei.duxin.dto.SystemStatus;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 产品打包列表 前端控制器
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Controller
@RequestMapping("/duxin/productPackage")
public class ProductPackageController {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ProductPackageController.class);

    @Autowired
    private IProductPackageService service;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean pageQuery(@RequestBody ProductPackageQueryBean queryBean) {
        if (queryBean.getPageSize() <= 0) {
            queryBean.setPageSize(20);
        }
        if (queryBean.getPageNo() < 0) {
            queryBean.setPageNo(0);
        }
        ResultBean resultBean = new ResultBean();
        try {
            resultBean = service.listByPage(queryBean);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
        }
        return resultBean;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean add(@RequestBody ProductPackageDTO dto) {
        ResultBean resultBean = new ResultBean();
//        if (StringUtils.isEmpty(usersDTO.getUsername())) {
//            resultBean.setFailMsg(200101,"用户名不能为空");
//            return resultBean;
//        }
//        if (StringUtils.isEmpty(usersDTO.getPassword())) {
//            resultBean.setFailMsg(200102,"密码不能为空");
//            return resultBean;
//        }
        try {
            resultBean = service.insert(dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public ResultBean update(@RequestBody ProductPackageDTO dto) {
        ResultBean resultBean = new ResultBean();
//        if (StringUtils.isEmpty(usersDTO.getId())) {
//            resultBean.setFailMsg(200104,"ID不能为空");
//            return resultBean;
//        }
        try {
            resultBean = service.update(dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultBean delete(int id) {
        ResultBean resultBean = new ResultBean();
//        if (id == 0) {
//            resultBean.setFailMsg(200104,"ID不能为空");
//            return resultBean;
//        }
        try {
            resultBean = service.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean get(int id) {
        ResultBean resultBean = new ResultBean();
//        if (id == 0) {
//            resultBean.setFailMsg(200104,"ID不能为空");
//            return resultBean;
//        }
        try {
            resultBean = service.get(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

}

