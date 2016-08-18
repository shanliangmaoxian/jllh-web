package com.jllh.beans;

import java.util.Date;

/**
 * 工单
 * Created by maoxian on 16/8/18.
 */
public class WorkOrderBean {

    private Integer id;
    //系统类型
    private String sysNtype;
    //企业名称
    private String sysCpyname;
    //企业id
    private Integer sysCpyid;
    //用户名
    private String sysUser;
    //密码
    private String sysPas;
    //备注
    private String sysRemark;
    //创建时间
    private Date sysCreatetime;
    //创建人
    private String sysCreateuser;
    //解决时间
    private Date sysUpdatetime;
    //是否解决
    private Integer sysIsUpdate;
    //解决人
    private String sysUpdateuser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysNtype() {
        return sysNtype;
    }

    public void setSysNtype(String sysNtype) {
        this.sysNtype = sysNtype;
    }

    public String getSysCpyname() {
        return sysCpyname;
    }

    public void setSysCpyname(String sysCpyname) {
        this.sysCpyname = sysCpyname;
    }

    public Integer getSysCpyid() {
        return sysCpyid;
    }

    public void setSysCpyid(Integer sysCpyid) {
        this.sysCpyid = sysCpyid;
    }

    public String getSysUser() {
        return sysUser;
    }

    public void setSysUser(String sysUser) {
        this.sysUser = sysUser;
    }

    public String getSysPas() {
        return sysPas;
    }

    public void setSysPas(String sysPas) {
        this.sysPas = sysPas;
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }

    public Date getSysCreatetime() {
        return sysCreatetime;
    }

    public void setSysCreatetime(Date sysCreatetime) {
        this.sysCreatetime = sysCreatetime;
    }

    public String getSysCreateuser() {
        return sysCreateuser;
    }

    public void setSysCreateuser(String sysCreateuser) {
        this.sysCreateuser = sysCreateuser;
    }

    public Date getSysUpdatetime() {
        return sysUpdatetime;
    }

    public void setSysUpdatetime(Date sysUpdatetime) {
        this.sysUpdatetime = sysUpdatetime;
    }

    public Integer getSysIsUpdate() {
        return sysIsUpdate;
    }

    public void setSysIsUpdate(Integer sysIsUpdate) {
        this.sysIsUpdate = sysIsUpdate;
    }

    public String getSysUpdateuser() {
        return sysUpdateuser;
    }

    public void setSysUpdateuser(String sysUpdateuser) {
        this.sysUpdateuser = sysUpdateuser;
    }
}