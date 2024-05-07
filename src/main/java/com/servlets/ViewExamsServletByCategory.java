package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ExamDao;
import com.model.Exam;

@WebServlet("/ViewExamsServletByCategory")
public class ViewExamsServletByCategory extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        List<Exam> exams = ExamDao.getAllExamsByCategoryId(categoryId);
        request.setAttribute("exams", exams);
        request.getRequestDispatcher("viewExamsByCategory.jsp").forward(request, response);
    }
}

