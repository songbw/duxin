package com.jiannei.duxin.controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jiannei.duxin.service.IResourceService;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.ResourceQueryBean;
import com.jiannei.duxin.dto.ResourceDTO;
import com.jiannei.duxin.dto.SystemStatus;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Controller
@RequestMapping("/duxin/resource")
public class ResourceController {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ResourceController.class);

    @Autowired
    private IResourceService service;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean pageQuery(@RequestBody ResourceQueryBean queryBean) {
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
    public ResultBean add(@RequestBody ResourceDTO dto) {
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
    public ResultBean update(@RequestBody ResourceDTO dto) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isEmpty(dto.getId())) {
            resultBean.setFailMsg(SystemStatus.ID_IS_NULL);
            return resultBean;
        }
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
        if (id == 0) {
            resultBean.setFailMsg(SystemStatus.ID_IS_NULL);
            return resultBean;
        }
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
        if (id == 0) {
            resultBean.setFailMsg(SystemStatus.ID_IS_NULL);
            return resultBean;
        }
        try {
            resultBean = service.get(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    /**
     * 根据角色ID获取该角色资源列表
     *
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean getByRole(int roleId) {
        ResultBean resultBean = new ResultBean();
        if (roleId == 0) {
            resultBean.setFailMsg(SystemStatus.ID_IS_NULL);
            return resultBean;
        }
        try {
            resultBean = service.getByRole(roleId);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping(value = "/lock", method = RequestMethod.PUT)
    @ResponseBody
    public ResultBean updateLock(@RequestBody ResourceDTO dto) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isEmpty(dto.getId())) {
            resultBean.setFailMsg(SystemStatus.ID_IS_NULL);
            return resultBean;
        }
        try {
            resultBean = service.updateAvailable(dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

}

