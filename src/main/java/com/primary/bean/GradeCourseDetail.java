package com.primary.bean;

public class GradeCourseDetail {
    private String coursename;

    private Integer gCId;

    private Integer courseid;

    private Integer gradeid;

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
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

	@Override
	public String toString() {
		return "GradeCourseDetail [coursename=" + coursename + ", gCId=" + gCId + ", courseid=" + courseid
				+ ", gradeid=" + gradeid + "]";
	}
    
    
}