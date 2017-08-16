package com.primary.bean;

public class Stuff {
    private Integer stuffid;

    private Integer authority;

    private String name;

    private String password;

    public Stuff() {
		super();
	}

	public Stuff(Integer stuffid, Integer authority, String name, String password) {
		super();
		this.stuffid = stuffid;
		this.authority = authority;
		this.name = name;
		this.password = password;
	}

	public Integer getStuffid() {
        return stuffid;
    }

    public void setStuffid(Integer stuffid) {
        this.stuffid = stuffid;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}