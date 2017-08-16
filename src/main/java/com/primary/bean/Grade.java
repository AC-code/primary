package com.primary.bean;

public class Grade {
    private Integer gradeid;

    private String gradename;

    private Integer sessnid;

    public Grade() {
		super();
	}

	public Grade(Integer gradeid, String gradename, Integer sessnid) {
		super();
		this.gradeid = gradeid;
		this.gradename = gradename;
		this.sessnid = sessnid;
	}

	public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public Integer getSessnid() {
        return sessnid;
    }

    public void setSessnid(Integer sessnid) {
        this.sessnid = sessnid;
    }
}