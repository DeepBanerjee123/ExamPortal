package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.dbutility.DBUtility;
import com.model.Exam;

public class ExamDao {

    public static boolean createExam(Exam exam, HttpSession session) {
      //  long teacherId = (long) session.getAttribute("teacherId");
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "INSERT INTO Exam (title, durationMinutes, highestMarks, scheduleDate, categoryId, teacherId) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, exam.getTitle());
                statement.setLong(2, exam.getDurationMinutes());
                statement.setDouble(3, exam.getHighestMarks());
                statement.setDate(4, new java.sql.Date(exam.getScheduleDate().getTime()));
                statement.setLong(5, exam.getCategoryId());
                statement.setLong(6, exam.getTeacherId());
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Exam> getAllExams() {
        List<Exam> exams = new ArrayList<>();
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Exam";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Exam exam = extractExamFromResultSet(resultSet);
                        exams.add(exam);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }

    public static Exam getExamById(long examId) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Exam WHERE examId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, examId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return extractExamFromResultSet(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateExam(Exam exam) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "UPDATE Exam SET title = ?, durationMinutes = ?, highestMarks = ?, scheduleDate = ?, categoryId = ? WHERE examId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, exam.getTitle());
                statement.setLong(2, exam.getDurationMinutes());
                statement.setDouble(3, exam.getHighestMarks());
                statement.setDate(4, new java.sql.Date(exam.getScheduleDate().getTime()));
                statement.setLong(5, exam.getCategoryId());
                statement.setLong(6, exam.getExamId());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteExam(long examId) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "DELETE FROM Exam WHERE examId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, examId);
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Exam extractExamFromResultSet(ResultSet resultSet) throws SQLException {
        long examId = resultSet.getLong("examId");
        String title = resultSet.getString("title");
        long durationMinutes = resultSet.getLong("durationMinutes");
        double highestMarks = resultSet.getDouble("highestMarks");
        Date scheduleDate = resultSet.getDate("scheduleDate");
        long categoryId = resultSet.getLong("categoryId");
        long teacherId = resultSet.getLong("teacherId");
        Exam exam = new Exam(title, durationMinutes, highestMarks, scheduleDate, categoryId, teacherId);
        exam.setExamId(examId);
        return exam;
    }
    
    public static List<Exam> getAllExamsByCategoryId(long categoryId) {
        List<Exam> exams = new ArrayList<>();
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Exam WHERE categoryId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, categoryId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Exam exam = extractExamFromResultSet(resultSet);
                        exams.add(exam);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exams;
    }
}

