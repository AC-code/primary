package com.primary.bean;

public class TeacherClassDetail {
    private Integer stuffid;

    private String sessnname;

    private String gradename;

    private String classname;

    private Integer classid;

    public Integer getStuffid() {
        return stuffid;
    }

    public void setStuffid(Integer stuffid) {
        this.stuffid = stuffid;
    }

    public String getSessnname() {
        return sessnname;
    }

    public void setSessnname(String sessnname) {
        this.sessnname = sessnname == null ? null : sessnname.trim();
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}