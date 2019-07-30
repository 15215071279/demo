package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * pk
     */
    private Long id;

    private String appid;

    /**
     * 部门id
     */
    private Long groupid;

    /**
     * 部门岗位id
     */
    private Long roleid;

    /**
     * 微信opened
     */
    private String openid;

    /**
     * 手机号
     */
    private String msisdn;

    /**
     * 登陆用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 头像
     */
    private String img;

    /**
     * 男女
     */
    private String sexs;

    /**
     * 居住地址
     */
    private String raddress;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 银行卡号
     */
    private String cardnum;

    /**
     * 入职时间
     */
    private Date etime;

    /**
     * 备注
     */
    private String note;

    /**
     * 状态  0未激活/1激活
     */
    private Integer st;

    /**
     * 渠道类型 0招商员 1推广员 2集团客户 3第三方客户
     */
    private Integer channeltype;

    /**
     * 上线渠道id
     */
    private Long pid;

    /**
     * 推荐码
     */
    private String rcode;

    /**
     * 招商员id
     */
    private Long rid;

    private Date ctime;

    private Date utime;

    private String channelstring;

    private String tgy;

    private String tgymsisdn;

    /**
     * 是否已退休 1已退休
     */
    private String retirest;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn == null ? null : msisdn.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getSexs() {
        return sexs;
    }

    public void setSexs(String sexs) {
        this.sexs = sexs == null ? null : sexs.trim();
    }

    public String getRaddress() {
        return raddress;
    }

    public void setRaddress(String raddress) {
        this.raddress = raddress == null ? null : raddress.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum == null ? null : cardnum.trim();
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getSt() {
        return st;
    }

    public void setSt(Integer st) {
        this.st = st;
    }

    public Integer getChanneltype() {
        return channeltype;
    }

    public void setChanneltype(Integer channeltype) {
        this.channeltype = channeltype;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode == null ? null : rcode.trim();
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    public String getChannelstring() {
        return channelstring;
    }

    public void setChannelstring(String channelstring) {
        this.channelstring = channelstring == null ? null : channelstring.trim();
    }

    public String getTgy() {
        return tgy;
    }

    public void setTgy(String tgy) {
        this.tgy = tgy == null ? null : tgy.trim();
    }

    public String getTgymsisdn() {
        return tgymsisdn;
    }

    public void setTgymsisdn(String tgymsisdn) {
        this.tgymsisdn = tgymsisdn == null ? null : tgymsisdn.trim();
    }

    public String getRetirest() {
        return retirest;
    }

    public void setRetirest(String retirest) {
        this.retirest = retirest == null ? null : retirest.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appid=").append(appid);
        sb.append(", groupid=").append(groupid);
        sb.append(", roleid=").append(roleid);
        sb.append(", openid=").append(openid);
        sb.append(", msisdn=").append(msisdn);
        sb.append(", username=").append(username);
        sb.append(", pwd=").append(pwd);
        sb.append(", img=").append(img);
        sb.append(", sexs=").append(sexs);
        sb.append(", raddress=").append(raddress);
        sb.append(", idcard=").append(idcard);
        sb.append(", cardnum=").append(cardnum);
        sb.append(", etime=").append(etime);
        sb.append(", note=").append(note);
        sb.append(", st=").append(st);
        sb.append(", channeltype=").append(channeltype);
        sb.append(", pid=").append(pid);
        sb.append(", rcode=").append(rcode);
        sb.append(", rid=").append(rid);
        sb.append(", ctime=").append(ctime);
        sb.append(", utime=").append(utime);
        sb.append(", channelstring=").append(channelstring);
        sb.append(", tgy=").append(tgy);
        sb.append(", tgymsisdn=").append(tgymsisdn);
        sb.append(", retirest=").append(retirest);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}