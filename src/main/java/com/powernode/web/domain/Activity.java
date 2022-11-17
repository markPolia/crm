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
    private String startDate;
    /**
     *  结束日期    10位
     */
    private String endDate;
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
    private String createTime;
    /**
     *  创建者
     */
    private String createBy;
    /**
     *  修改时间    19位
     */
    private String editTime;
    /**
     *  修改人
     */
    private String editBy;

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime == null ? null : editTime.trim();
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy == null ? null : editBy.trim();
    }
}