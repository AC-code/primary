package com.primary.bean;

public class Session {
    private Integer sessnid;

    private String sessnname;
    
    public Session() {
		super();
	}

	public Session(Integer sessnid, String sessnname) {
		super();
		this.sessnid = sessnid;
		this.sessnname = sessnname;
	}

	public Integer getSessnid() {
        return sessnid;
    }

    public void setSessnid(Integer sessnid) {
        this.sessnid = sessnid;
    }

    public String getSessnname() {
        return sessnname;
    }

    public void setSessnname(String sessnname) {
        this.sessnname = sessnname == null ? null : sessnname.trim();
    }
}