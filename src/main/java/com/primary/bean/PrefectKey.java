package com.primary.bean;

public class PrefectKey {
    private Integer stuffid;

    private Integer gradeid;

    public PrefectKey() {
		super();
	}

	public PrefectKey(Integer stuffid, Integer gradeid) {
		super();
		this.stuffid = stuffid;
		this.gradeid = gradeid;
	}

	public Integer getStuffid() {
        return stuffid;
    }

    public void setStuffid(Integer stuffid) {
        this.stuffid = stuffid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }
}