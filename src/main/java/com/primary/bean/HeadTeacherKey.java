package com.primary.bean;

public class HeadTeacherKey {
    private Integer classid;

    private Integer stuffid;
    
    public HeadTeacherKey() {
		super();
	}

	public HeadTeacherKey(Integer classid, Integer stuffid) {
		super();
		this.classid = classid;
		this.stuffid = stuffid;
	}

	public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getStuffid() {
        return stuffid;
    }

    public void setStuffid(Integer stuffid) {
        this.stuffid = stuffid;
    }
}