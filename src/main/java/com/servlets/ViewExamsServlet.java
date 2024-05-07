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

@WebServlet("/ViewExamsServlet")
public class ViewExamsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exam> exams = ExamDao.getAllExams();
        request.setAttribute("exams", exams);
        request.getRequestDispatcher("viewExams.jsp").forward(request, response);
    }
}

