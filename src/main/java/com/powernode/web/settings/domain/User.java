package com.powernode.web.settings.domain;

@SuppressWarnings("all")
public class User {
    /*
        时间的两种表现方式
        年月日 10位字符串
        yyyy-MM-dd

        时间  19位字符串
        yyyy-MM-dd HH:mm:ss
     */
    /*
        关于登陆

        User user = select * from t_user where loginAct = ? and loginPwd = ?
        user 不为空，说明账户存在
        但还需要进行
            expire-time 过期时间
            lock-state 锁定状态
            allow-ips 运行登陆ip
        的验证
     */

    /**
     * 主键
     */
    private String id;
    /**
     * 登陆账户
     */
    private String loginAct;
    /**
     *  真实姓名
     */
    private String name;
    /**
     *  登录密码
     */
    private String loginPwd;
    /**
     *  邮箱
     */
    private String email;
    /**
     *  失效时间 19
     */
    private String expireTime;
    /**
     *  锁定状态
     *  <pre>
     *      0 -锁定
     *      1 -启用</pre>
     */
    private String lockState;
    /**
     *  部门编号
     */
    private String deptNo;
    /**
     *  允许访问ip
     */
    private String allowIps;
    /**
     *  创建时间 19
     */
    private String createTime;
    /**
     *  创建人
     */
    private String createBy;
    /**
     *  修改时间    19
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

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct == null ? null : loginAct.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime == null ? null : expireTime.trim();
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState == null ? null : lockState.trim();
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps == null ? null : allowIps.trim();
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