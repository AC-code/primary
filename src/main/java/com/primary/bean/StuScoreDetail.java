package com.primary.bean;

public class StuScoreDetail {
    private Integer stuid;

    private Integer classid;

    private Integer number;

    private Float mark;

    private String name;

    private String coursename;

    private String classname;

    private String gradename;

    private String sessnname;

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
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

	@Override
	public String toString() {
		return "StuScoreDetail [stuid=" + stuid + ", classid=" + classid + ", number=" + number + ", mark=" + mark
				+ ", name=" + name + ", coursename=" + coursename + ", classname=" + classname + ", gradename="
				+ gradename + ", sessnname=" + sessnname + "]";
	}
    
    
}