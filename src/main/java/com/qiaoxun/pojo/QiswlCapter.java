package com.qiaoxun.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * qiswl_capter
 * @author 
 */
public class QiswlCapter implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 章节标题
     */
    private String title;//----ok

    /**
     * 章节封面图
     */
    private String image;//不知道是那张图

    /**
     * 创建时间
     */
    private Date createTime;//获取不到

    /**
     * 更新时间
     */
    private Date updateTime;//获取不到

    /**
     * 所属漫画:id:title
     */
    private Integer manhuaId;//----ok

    /**
     * 排序
     */
    private Integer sort;//----ok

    /**
     * 性别:0=免费,1=VIP
     */
    private String isvip;

    /**
     * 售价
     */
    private Integer score;

    /**
     * 阅读量
     */
    private Integer view;

    /**
     * 类型:2=小说,1=漫画
     */
    private Byte type;

    /**
     * 采集标识
     */
    private String cjid;

    /**
     * 采集渠道
     */
    private String cjname;

    /**
     * 上架状态:0=下架,1=正常
     */
    private Boolean switch1;

    /**
     * 采集状态
     */
    private Byte cjstatus;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getManhuaId() {
        return manhuaId;
    }

    public void setManhuaId(Integer manhuaId) {
        this.manhuaId = manhuaId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIsvip() {
        return isvip;
    }

    public void setIsvip(String isvip) {
        this.isvip = isvip;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCjid() {
        return cjid;
    }

    public void setCjid(String cjid) {
        this.cjid = cjid;
    }

    public String getCjname() {
        return cjname;
    }

    public void setCjname(String cjname) {
        this.cjname = cjname;
    }

    public Boolean getSwitch1() {
        return switch1;
    }

    public void setSwitch1(Boolean switch1) {
        this.switch1 = switch1;
    }

    public Byte getCjstatus() {
        return cjstatus;
    }

    public void setCjstatus(Byte cjstatus) {
        this.cjstatus = cjstatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        QiswlCapter other = (QiswlCapter) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getManhuaId() == null ? other.getManhuaId() == null : this.getManhuaId().equals(other.getManhuaId()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getIsvip() == null ? other.getIsvip() == null : this.getIsvip().equals(other.getIsvip()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getView() == null ? other.getView() == null : this.getView().equals(other.getView()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getCjid() == null ? other.getCjid() == null : this.getCjid().equals(other.getCjid()))
            && (this.getCjname() == null ? other.getCjname() == null : this.getCjname().equals(other.getCjname()))
            && (this.getSwitch1() == null ? other.getSwitch1() == null : this.getSwitch1().equals(other.getSwitch1()))
            && (this.getCjstatus() == null ? other.getCjstatus() == null : this.getCjstatus().equals(other.getCjstatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getManhuaId() == null) ? 0 : getManhuaId().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getIsvip() == null) ? 0 : getIsvip().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getView() == null) ? 0 : getView().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCjid() == null) ? 0 : getCjid().hashCode());
        result = prime * result + ((getCjname() == null) ? 0 : getCjname().hashCode());
        result = prime * result + ((getSwitch1() == null) ? 0 : getSwitch1().hashCode());
        result = prime * result + ((getCjstatus() == null) ? 0 : getCjstatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", image=").append(image);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", manhuaId=").append(manhuaId);
        sb.append(", sort=").append(sort);
        sb.append(", isvip=").append(isvip);
        sb.append(", score=").append(score);
        sb.append(", view=").append(view);
        sb.append(", type=").append(type);
        sb.append(", cjid=").append(cjid);
        sb.append(", cjname=").append(cjname);
        sb.append(", switch=").append(switch1);
        sb.append(", cjstatus=").append(cjstatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}