package com.model;

public class Teacher {
    private long teacherId;
    private String teacherName;
    private String teacherPassword;
    private String teacherEmail;

   
    public Teacher(String teacherName, String teacherPassword, String teacherEmail) {
        this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
        this.teacherEmail = teacherEmail;
    }
    
    public Teacher(  Long teacherId, String teacherName,  String teacherEmail) {
        this.teacherId= teacherId;
        this.teacherPassword = teacherPassword;
        this.teacherEmail = teacherEmail;
    }
    
    public Teacher(long teacherId, String teacherName, String teacherPassword, String teacherEmail) {
        this.teacherId = teacherId;
    	this.teacherName = teacherName;
        this.teacherPassword = teacherPassword;
        this.teacherEmail = teacherEmail;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

	
}
