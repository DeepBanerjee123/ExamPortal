package com.model;

import java.util.Date;

public class Exam {
    private long examId;
    private String title;
    private long durationMinutes;
    private double highestMarks;
    private Date scheduleDate;
    private long categoryId;
    private long teacherId;

 
    public Exam(String title, long durationMinutes, double highestMarks, Date scheduleDate, long categoryId, long teacherId) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.highestMarks = highestMarks;
        this.scheduleDate = scheduleDate;
        this.categoryId = categoryId;
        this.teacherId = teacherId;
    }


	public long getExamId() {
		return examId;
	}


	public void setExamId(long examId) {
		this.examId = examId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getDurationMinutes() {
		return durationMinutes;
	}


	public void setDurationMinutes(long durationMinutes) {
		this.durationMinutes = durationMinutes;
	}


	public double getHighestMarks() {
		return highestMarks;
	}


	public void setHighestMarks(double highestMarks) {
		this.highestMarks = highestMarks;
	}


	public Date getScheduleDate() {
		return scheduleDate;
	}


	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}


	public long getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}


	public long getCategoryId() {
		return categoryId;
	}

    
}
