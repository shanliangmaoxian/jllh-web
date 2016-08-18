package com.jllh.dao;

import com.jllh.beans.WorkOrderBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maoxian on 16/8/18.
 */
@Repository
public interface WorkOrderDao {

    int insert(WorkOrderBean workOrderBean);

    int update(WorkOrderBean workOrderBean);

    List<WorkOrderBean> select();

    WorkOrderBean findById(Integer id);
}
