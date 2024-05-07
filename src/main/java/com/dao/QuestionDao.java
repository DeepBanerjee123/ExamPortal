package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutility.DBUtility;
import com.model.Question;

public class QuestionDao {

    public static boolean addQuestion(Question question) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "INSERT INTO Question (examId, questionText, option1, option2, option3, option4, correct_ans) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, question.getExamId());
                statement.setString(2, question.getQuestionText());
                statement.setString(3, question.getOption1());
                statement.setString(4, question.getOption2());
                statement.setString(5, question.getOption3());
                statement.setString(6, question.getOption4());
                statement.setString(7, question.getCorrectAns());
                int rowsInserted = statement.executeUpdate();
                return rowsInserted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Question> getQuestionsByExamId(long examId) {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "SELECT * FROM Question WHERE examId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, examId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Question question = extractQuestionFromResultSet(resultSet);
                        questions.add(question);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public static boolean updateQuestion(Question question) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "UPDATE Question SET questionText = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, correct_ans = ? WHERE questionId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, question.getQuestionText());
                statement.setString(2, question.getOption1());
                statement.setString(3, question.getOption2());
                statement.setString(4, question.getOption3());
                statement.setString(5, question.getOption4());
                statement.setString(6, question.getCorrectAns());
                statement.setLong(7, question.getQuestionId());
                int rowsUpdated = statement.executeUpdate();
                return rowsUpdated > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteQuestion(long questionId) {
        try (Connection connection = DBUtility.getConnection()) {
            String sql = "DELETE FROM Question WHERE questionId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, questionId);
                int rowsDeleted = statement.executeUpdate();
                return rowsDeleted > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Question extractQuestionFromResultSet(ResultSet resultSet) throws SQLException {
        long questionId = resultSet.getLong("questionId");
        long examId = resultSet.getLong("examId");
        String questionText = resultSet.getString("questionText");
        String option1 = resultSet.getString("option1");
        String option2 = resultSet.getString("option2");
        String option3 = resultSet.getString("option3");
        String option4 = resultSet.getString("option4");
        String correctAns = resultSet.getString("correct_ans");
        return new Question(examId, questionText, option1, option2, option3, option4, correctAns);
    }
}

