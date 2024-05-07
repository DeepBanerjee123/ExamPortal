<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="com.dao.ExamDao" %>
<%@ page import="com.model.Exam" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%

    Long teacherIdObj = (Long) session.getAttribute("teacherId");
    long teacherId = (teacherIdObj != null) ? teacherIdObj : 0; 
    
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Exam</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="teacherNavbar.jsp" %>
    <div class="container">
        <h2>Create Exam</h2>
        <form action="CreateExamServlet" method="post">
            <input type="hidden" name="teacherId" value="<%= teacherId %>">
            <input type="hidden" name="categoryId" value="<%= request.getParameter("categoryId") %>">
            <div class="form-group">
                <label for="title">Title:</label>
                <input type="text" class="form-control" id="title" name="title" required>
            </div>
            <div class="form-group">
                <label for="durationMinutes">Duration (in minutes):</label>
                <input type="number" class="form-control" id="durationMinutes" name="durationMinutes" required>
            </div>
            <div class="form-group">
                <label for="highestMarks">Highest Marks:</label>
                <input type="number" step="0.01" class="form-control" id="highestMarks" name="highestMarks" required>
            </div>
            <div class="form-group">
                <label for="scheduleDate">Schedule Date:</label>
                <input type="date" class="form-control" id="scheduleDate" name="scheduleDate" required>
            </div>
            <button type="submit" class="btn btn-primary">Create Exam</button>
        </form>
    </div>
</body>
</html>
