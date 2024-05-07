<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="com.dao.ExamDao" %>
<%@ page import="com.model.Exam" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    long categoryId = Long.parseLong(request.getParameter("categoryId"));
    List<Exam> exams = ExamDao.getAllExamsByCategoryId(categoryId);
%>

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
                </tr>
            </thead>
            <tbody>
                <% 
                    for(Exam exam : exams) {
                %>
                <tr>
                    <td><%= exam.getExamId() %></td>
                    <td><%= exam.getTitle() %></td>
                    <td><%= exam.getDurationMinutes() %></td>
                    <td><%= exam.getHighestMarks() %></td>
                    <td><%= exam.getScheduleDate() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
