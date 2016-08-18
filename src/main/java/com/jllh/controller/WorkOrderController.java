package com.jllh.controller;

import com.jllh.beans.WorkOrderBean;
import com.jllh.service.WorkOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Created by maoxian on 16/8/18.
 */
@Controller
public class WorkOrderController {

    @Resource
    private WorkOrderService workOrderService;

    /**
     * @description 主页跳转.
     * @return 主页
     * @author maoxian 
     * @date 2016-07-22 16:22:54
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root(ModelMap model){
        model.addAttribute("workOrder", this.workOrderService.select());
        return "index";
    }


    @RequestMapping(value = "/work/order/insert")
    public String insert(WorkOrderBean workOrderBean, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("UTF-8");

        if(StringUtils.isEmpty(workOrderBean.getSysCpyname())) {
            model.addAttribute("msg", "企业名称为空,添加失败!");
            return this.root(model);
        }

        if(StringUtils.isEmpty(workOrderBean.getSysCreateuser())) {
            model.addAttribute("msg", "提交人为空,添加失败!");
            return this.root(model);
        }

        workOrderBean.setSysCreatetime(new Date());
        workOrderBean.setSysIsUpdate(0);
        this.workOrderService.insert(workOrderBean);
        model.addAttribute("msg", "添加成功!");

        response.sendRedirect("/");
        return null;
    }


    @RequestMapping(value = "/work/order/update")
    public String insert(Integer id, ModelMap model,HttpServletResponse response){
       return this.updateWork(id, 1, model, response);
    }

    @RequestMapping(value = "/work/order/delete")
    public String findById(Integer id, ModelMap model, HttpServletResponse response){
        return this.updateWork(id, 2, model, response);
    }


    public String updateWork(Integer id, Integer isupdate, ModelMap model, HttpServletResponse response){
        if(null == id){
            model.addAttribute("msg", "ID为空,操作失败");
            return this.root(model);
        }
        WorkOrderBean workOrderBean = new WorkOrderBean();
        workOrderBean.setId(id);
        workOrderBean.setSysUpdatetime(new Date());
        workOrderBean.setSysIsUpdate(isupdate);
        this.workOrderService.update(workOrderBean);
        try{
            response.sendRedirect("/");
        }catch (Exception e){
            System.out.println("转发异常");
        }
        return this.root(model);
    }
}
