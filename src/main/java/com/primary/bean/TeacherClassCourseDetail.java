package com.primary.bean;

public class TeacherClassCourseDetail {
    private String coursename;

    private Integer gCId;

    private Integer stuffid;

    private Integer classid;

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public Integer getgCId() {
        return gCId;
    }

    public void setgCId(Integer gCId) {
        this.gCId = gCId;
    }

    public Integer getStuffid() {
        return stuffid;
    }

    public void setStuffid(Integer stuffid) {
        this.stuffid = stuffid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}