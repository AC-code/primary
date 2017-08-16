package com.primary.bean;

public class GradePrefect {
    private String name;

    private Integer stuffid;

    private Integer gradeid;

    private String gradename;

    private String sessnname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStuffid() {
        return stuffid;
    }

    public void setStuffid(Integer stuffid) {
        this.stuffid = stuffid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public String getSessnname() {
        return sessnname;
    }

    public void setSessnname(String sessnname) {
        this.sessnname = sessnname == null ? null : sessnname.trim();
    }
}