package com.jiannei.duxin.controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jiannei.duxin.service.IAdminService;
import com.jiannei.duxin.dto.ResultBean;
import com.jiannei.duxin.query.AdminQueryBean;
import com.jiannei.duxin.dto.AdminDTO;
import com.jiannei.duxin.dto.SystemStatus;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author Songbw
 * @since 2018-01-26
 */
@Controller
@RequestMapping("/duxin/admin")
public class AdminController {

    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AdminController.class);

    @Autowired
    private IAdminService service;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean pageQuery(@RequestBody AdminQueryBean queryBean) {
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
    public ResultBean add(@RequestBody AdminDTO dto) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isEmpty(dto.getUsername())) {
            resultBean.setFailMsg(SystemStatus.USERNAME_IS_NULL);
            return resultBean;
        }
        if (StringUtils.isEmpty(dto.getPassword())) {
            resultBean.setFailMsg(SystemStatus.PASSWORD_IS_NULL);
            return resultBean;
        }
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
    public ResultBean update(@RequestBody AdminDTO dto) {
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

    @RequestMapping(value = "/lock", method = RequestMethod.PUT)
    @ResponseBody
    public ResultBean updateLock(@RequestBody AdminDTO dto) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isEmpty(dto.getId())) {
            resultBean.setFailMsg(SystemStatus.ID_IS_NULL);
            return resultBean;
        }
        try {
            resultBean = service.updateLocked(dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping(value = "/passwd", method = RequestMethod.PUT)
    @ResponseBody
    public ResultBean updatePasswd(@RequestBody AdminDTO dto) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isEmpty(dto.getId())) {
            resultBean.setFailMsg(SystemStatus.ID_IS_NULL);
            return resultBean;
        }
        try {
            resultBean = service.updatePasswd(dto);
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean login(@RequestBody AdminDTO dto) {
        ResultBean resultBean = new ResultBean();
        if (StringUtils.isEmpty(dto.getUsername())) {
            resultBean.setFailMsg(SystemStatus.USERNAME_IS_NULL);
            return resultBean;
        }
        if (StringUtils.isEmpty(dto.getPassword())) {
            resultBean.setFailMsg(SystemStatus.PASSWORD_IS_NULL);
            return resultBean;
        }
        try {
            resultBean = service.login(dto);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultBean logout(String refreshToken) {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean = service.logout(refreshToken);
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean;
        }
        return resultBean;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    @ResponseBody
    public ResultBean profile(String token) {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean = service.getUserByToken(token) ;
        } catch (Exception e) {
            log.error(e.getMessage());
            resultBean.setFailMsg(SystemStatus.SERVER_ERROR);
            return resultBean ;
        }
        return resultBean ;
    }

}

