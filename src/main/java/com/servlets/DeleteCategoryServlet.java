package com.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CategoryDao;

@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        
        boolean success = CategoryDao.deleteCategory(categoryId);
        
        if(success) {
            response.sendRedirect("viewCategories.jsp");
        } else {
            response.getWriter().println("Failed to delete category.");
        }
    }
}

