package com.jllh.service.impl;

import com.jllh.beans.WorkOrderBean;
import com.jllh.dao.WorkOrderDao;
import com.jllh.service.WorkOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by maoxian on 16/8/18.
 */
@Service
public class WorkOrderServiceImpl implements WorkOrderService{

    @Resource
    private WorkOrderDao workOrderDao;

    public int insert(WorkOrderBean workOrderBean) {
        return this.workOrderDao.insert(workOrderBean);
    }

    public int update(WorkOrderBean workOrderBean) {
        return this.workOrderDao.update(workOrderBean);
    }

    public List<WorkOrderBean> select() {
        return this.workOrderDao.select();
    }

    public WorkOrderBean findById(Integer id) {
        return this.workOrderDao.findById(id);
    }
}
