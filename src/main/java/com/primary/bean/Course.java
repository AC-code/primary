package com.primary.bean;

public class Course {
    private Integer courseid;

    private String coursename;

    public Course() {
		super();
	}
    
	public Course(Integer courseid, String coursename) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
	}

	public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename == null ? null : coursename.trim();
    }
}