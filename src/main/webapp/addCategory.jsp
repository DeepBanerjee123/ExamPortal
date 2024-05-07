<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Category</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .center-div {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>
	<%@ include file="teacherNavbar.jsp" %>
    <div class="container center-div">
        <div class="col-md-6">
            <h2 class="mb-4">Add Category</h2>
            <form action="AddCategoryServlet" method="post">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name">
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" name="description">
                </div>
                <button type="submit" class="btn btn-primary">Add Category</button>
            </form>
        </div>
    </div>
</body>
</html>
