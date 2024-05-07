package com.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;
import com.model.Category;

@WebServlet("/UpdateCategoryServlet")
public class UpdateCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        
        Category category = new Category(categoryId, name, description);
        
        boolean success = CategoryDao.updateCategory(category);
        
        if(success) {
            response.sendRedirect("viewCategories.jsp");
        } else {
            response.getWriter().println("Failed to update category.");
        }
    }
}
