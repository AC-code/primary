package com.primary.bean;

public class Student {
    private Integer stuid;

    private String stuname;

    private String password;

    public Student() {
		super();
	}

	public Student(Integer stuid, String stuname, String password) {
		super();
		this.stuid = stuid;
		this.stuname = stuname;
		this.password = password;
	}

	public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}