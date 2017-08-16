package com.primary.bean;

public class Classes {
    private Integer classid;

    private String classname;

    private Integer gradeid;

    public Classes() {
		super();
	}

	public Classes(Integer classid, String classname, Integer gradeid) {
		super();
		this.classid = classid;
		this.classname = classname;
		this.gradeid = gradeid;
	}

	public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }
}