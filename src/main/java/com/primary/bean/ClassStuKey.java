package com.primary.bean;

public class ClassStuKey {
    private Integer number;

    private Integer classid;

    public ClassStuKey() {
		super();
	}

	public ClassStuKey(Integer number, Integer classid) {
		super();
		this.number = number;
		this.classid = classid;
	}

	public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}