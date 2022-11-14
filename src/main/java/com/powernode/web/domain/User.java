package com.powernode.web.domain;

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

        User user = select * from t_user where loginact = ? and loginpwd = ?
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
    private String loginact;
    /**
     *  真实姓名
     */
    private String name;
    /**
     *  登录密码
     */
    private String loginpwd;
    /**
     *  邮箱
     */
    private String email;
    /**
     *  失效时间 19
     */
    private String expiretime;
    /**
     *  锁定状态
     *  <pre>
     *      0 -锁定
     *      1 -启用</pre>
     */
    private String lockstate;
    /**
     *  部门编号
     */
    private String deptno;
    /**
     *  允许访问ip
     */
    private String allowips;
    /**
     *  创建时间 19
     */
    private String createtime;
    /**
     *  创建人
     */
    private String createby;
    /**
     *  修改时间    19
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

    public String getLoginact() {
        return loginact;
    }

    public void setLoginact(String loginact) {
        this.loginact = loginact == null ? null : loginact.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime == null ? null : expiretime.trim();
    }

    public String getLockstate() {
        return lockstate;
    }

    public void setLockstate(String lockstate) {
        this.lockstate = lockstate == null ? null : lockstate.trim();
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno == null ? null : deptno.trim();
    }

    public String getAllowips() {
        return allowips;
    }

    public void setAllowips(String allowips) {
        this.allowips = allowips == null ? null : allowips.trim();
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