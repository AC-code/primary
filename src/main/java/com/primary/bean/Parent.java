package com.primary.bean;

public class Parent {
    private Integer parentid;

    private Integer stuid;

    private String password;

    public Parent() {
		super();
	}

	public Parent(Integer parentid, Integer stuid, String password) {
		super();
		this.parentid = parentid;
		this.stuid = stuid;
		this.password = password;
	}

	public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}