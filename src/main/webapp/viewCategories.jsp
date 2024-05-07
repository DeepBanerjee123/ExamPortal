<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>  
<%@ page import="com.model.Category" %>
<%@ page import="com.dao.CategoryDao" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Categories</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <%@ include file="teacherNavbar.jsp" %>
    <div class="container">
        <h2>Categories</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Category> categories = CategoryDao.getAllCategories();
                    for(Category category : categories) {
                %>
                <tr>
                    <td><%= category.getCategoryId() %></td>
                    <td><%= category.getName() %></td>
                    <td><%= category.getDescription() %></td>
                    <td>
                        <a href="updateCategory.jsp?categoryId=<%= category.getCategoryId() %>" class="btn btn-primary">Update</a>
                        <a href="DeleteCategoryServlet?categoryId=<%= category.getCategoryId() %>" class="btn btn-danger">Delete</a>
   					    <a href="createExam.jsp?categoryId=<%= category.getCategoryId() %>" class="btn btn-primary">Create Exam</a>
    					<a href="viewExamsByCategory.jsp?categoryId=<%= category.getCategoryId() %>" class="btn btn-secondary">View Exams</a>

                        
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
