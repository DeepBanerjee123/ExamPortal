package com.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExamDao;
import com.model.Exam;

@WebServlet("/CreateExamServlet")
public class CreateExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        long teacherId = Long.parseLong(request.getParameter("teacherId"));
        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        String title = request.getParameter("title");
        long durationMinutes = Long.parseLong(request.getParameter("durationMinutes"));
        double highestMarks = Double.parseDouble(request.getParameter("highestMarks"));
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedDate;
        try {
            parsedDate = sdf.parse(request.getParameter("scheduleDate"));
        } catch (ParseException e) {
            // Handle parsing error
            e.printStackTrace();
            return;
        }
        Date scheduleDate = new Date(parsedDate.getTime());

        Exam exam = new Exam(title, durationMinutes, highestMarks, scheduleDate, categoryId, teacherId);
        boolean created = ExamDao.createExam(exam, session);
        if (created) {
        	response.sendRedirect("viewExamsByCategory.jsp?categoryId=" + categoryId);
        } else {
        	response.getWriter().println("Failed to add exam.");
        }
    }
}
