<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Category</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        /* Center the form */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Update Category</h2>
        <%-- Retrieve category details from request --%>
        <% 
            long categoryId = Long.parseLong(request.getParameter("categoryId"));
            com.model.Category category = com.dao.CategoryDao.getCategoryById(categoryId);
            if (category != null) {
        %>
        <form action="UpdateCategoryServlet" method="post">
            <input type="hidden" name="categoryId" value="<%= categoryId %>">
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="<%= category.getName() %>">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description:</label>
                <input type="text" class="form-control" id="description" name="description" value="<%= category.getDescription() %>">
            </div>
            <button type="submit" class="btn btn-primary">Update Category</button>
        </form>
        <% } else { %>
        <p>Category not found.</p>
        <% } %>
    </div>
</body>
</html>
