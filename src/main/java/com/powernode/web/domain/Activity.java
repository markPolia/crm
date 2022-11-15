package com.powernode.web.domain;

@SuppressWarnings("all")
public class Activity {
    /**
     *  主键
     */
    private String id;
    /**
     *  市场活动所有者  关联t_user表的外键
     */
    private String owner;
    /**
     *  真实姓名
     */
    private String name;
    /**
     *  开始日期    10位
     */
    private String startdate;
    /**
     *  结束日期    10位
     */
    private String enddate;
    /**
     *  成本
     */
    private String cost;
    /**
     *  描述
     */
    private String description;
    /**
     *  创建时间   19位
     */
    private String createtime;
    /**
     *  创建者
     */
    private String createby;
    /**
     *  修改时间    19位
     */
    private String edittime;
    /**
     *  修改人
     */
    private String editby;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate == null ? null : startdate.trim();
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate == null ? null : enddate.trim();
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost == null ? null : cost.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby == null ? null : createby.trim();
    }

    public String getEdittime() {
        return edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime == null ? null : edittime.trim();
    }

    public String getEditby() {
        return editby;
    }

    public void setEditby(String editby) {
        this.editby = editby == null ? null : editby.trim();
    }
}