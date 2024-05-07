package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutility.DBUtility;
import com.model.Teacher;

public class TeacherDao {
    
   
    public static boolean insertTeacher(Teacher teacher) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "INSERT INTO Teacher (teacherName, teacherPassword, teacherEmail) VALUES (?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, teacher.getTeacherName());
                statement.setString(2, teacher.getTeacherPassword());
                statement.setString(3, teacher.getTeacherEmail());
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public static boolean updateTeacher(Teacher teacher) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "UPDATE Teacher SET teacherName = ?, teacherPassword = ?, teacherEmail = ? WHERE teacherId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, teacher.getTeacherName());
                statement.setString(2, teacher.getTeacherPassword());
                statement.setString(3, teacher.getTeacherEmail());
                statement.setLong(4, teacher.getTeacherId());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    public static boolean deleteTeacher(long teacherId) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "DELETE FROM Teacher WHERE teacherId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, teacherId);
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
   
    public static List<Teacher> getAllTeachers() {
    	
        List<Teacher> teachers = new ArrayList<>();
        
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Teacher";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    long teacherId = resultSet.getLong("teacherId");
                    String teacherName = resultSet.getString("teacherName");
                    String teacherPassword = resultSet.getString("teacherPassword");
                    String teacherEmail = resultSet.getString("teacherEmail");
                    Teacher teacher = new Teacher(teacherId, teacherName, teacherPassword, teacherEmail);
                    teachers.add(teacher);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
    
    public static Teacher authenticateTeacher(String email, String password) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Teacher WHERE teacherEmail = ? AND teacherPassword = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                       
                        long teacherId = resultSet.getLong("teacherId");
                        String teacherName = resultSet.getString("teacherName");
                        String teacherEmail = resultSet.getString("teacherEmail");
                        return new Teacher(teacherId, teacherName, teacherEmail);
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
