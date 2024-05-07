package com.servlets;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.model.Category;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> categories = CategoryDao.getAllCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryName = request.getParameter("name");
        String categoryDescription = request.getParameter("description");

        Category category = new Category(categoryName, categoryDescription);

        boolean success;

        if (request.getParameter("categoryId") != null) {
       
            long categoryId = Long.parseLong(request.getParameter("categoryId"));
            category.setCategoryId(categoryId);
            success = CategoryDao.updateCategory(category);
        } else {
           
            success = CategoryDao.insertCategory(category);
        }

        if (success) {
            response.sendRedirect("teacherDashboard.jsp");
        } else {
            response.getWriter().println("Failed to perform the operation.");
        }
    }
}
