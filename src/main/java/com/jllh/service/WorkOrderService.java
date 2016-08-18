package com.jllh.service;

import com.jllh.beans.WorkOrderBean;

import java.util.List;

/**
 * Created by maoxian on 16/8/18.
 */
public interface WorkOrderService {

    int insert(WorkOrderBean workOrderBean);

    int update(WorkOrderBean workOrderBean);

    List<WorkOrderBean> select();

    WorkOrderBean findById(Integer id);
}
