package com.primary.bean;

public class ClassCourseGrade {
    private Integer id;

    private Integer classid;

    private Integer gCId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getgCId() {
        return gCId;
    }

    public void setgCId(Integer gCId) {
        this.gCId = gCId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "ClassCourseGrade [id=" + id + ", classid=" + classid + ", gCId=" + gCId + ", name=" + name + "]";
	}
    
}