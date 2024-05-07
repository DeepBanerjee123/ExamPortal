<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.model.Exam" %>
<%@ page import="com.dao.ExamDao" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Exams</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="teacherNavbar.jsp" %>
    <div class="container">
        <h2>Exams</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Duration (minutes)</th>
                    <th>Highest Marks</th>
                    <th>Schedule Date</th>
                    <th>Category ID</th>
                    <th>Teacher ID</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Exam> exams = ExamDao.getAllExams();
                    for(Exam exam : exams) {
                %>
                <tr>
                    <td><%= exam.getExamId() %></td>
                    <td><%= exam.getTitle() %></td>
                    <td><%= exam.getDurationMinutes() %></td>
                    <td><%= exam.getHighestMarks() %></td>
                    <td><%= exam.getScheduleDate() %></td>
                    <td><%= exam.getCategoryId() %></td>
                    <td><%= exam.getTeacherId() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.model.Exam" %>
<%@ page import="com.dao.ExamDao" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Exams</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="teacherNavbar.jsp" %>
    <div class="container">
        <h2>Exams</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Duration (minutes)</th>
                    <th>Highest Marks</th>
                    <th>Schedule Date</th>
                    <th>Category ID</th>
                    <th>Teacher ID</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Exam> exams = ExamDao.getAllExams();
                    for(Exam exam : exams) {
                %>
                <tr>
                    <td><%= exam.getExamId() %></td>
                    <td><%= exam.getTitle() %></td>
                    <td><%= exam.getDurationMinutes() %></td>
                    <td><%= exam.getHighestMarks() %></td>
                    <td><%= exam.getScheduleDate() %></td>
                    <td><%= exam.getCategoryId() %></td>
                    <td><%= exam.getTeacherId() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
