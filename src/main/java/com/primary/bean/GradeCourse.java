package com.primary.bean;

public class GradeCourse {
    private Integer gCId;

    private Integer courseid;

    private Integer gradeid;

    public GradeCourse() {
		super();
	}

	public GradeCourse(Integer gCId, Integer courseid, Integer gradeid) {
		super();
		this.gCId = gCId;
		this.courseid = courseid;
		this.gradeid = gradeid;
	}

	public Integer getgCId() {
        return gCId;
    }

    public void setgCId(Integer gCId) {
        this.gCId = gCId;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }
}